package com.inductiveautomation.opcua.stack.client.fsm.states;

import java.util.concurrent.CompletableFuture;

import com.inductiveautomation.opcua.stack.client.UaTcpClient;
import com.inductiveautomation.opcua.stack.client.fsm.ConnectionStateContext;
import com.inductiveautomation.opcua.stack.client.fsm.ConnectionStateEvent;
import com.inductiveautomation.opcua.stack.core.types.builtin.DateTime;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.structured.CloseSecureChannelRequest;
import com.inductiveautomation.opcua.stack.core.types.structured.RequestHeader;
import io.netty.channel.Channel;

import static com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

public class ConnectedState implements ConnectionState {

    private final CompletableFuture<Channel> channelFuture;

    public ConnectedState(CompletableFuture<Channel> channelFuture) {
        this.channelFuture = channelFuture;
    }

    @Override
    public ConnectionState transition(ConnectionStateEvent event, ConnectionStateContext context) {
        switch(event) {
            case DisconnectRequested:
                channelFuture.thenAccept(ch -> {
                    RequestHeader requestHeader = new RequestHeader(
                            NodeId.NULL_VALUE, DateTime.now(), uint(0), uint(0), null, uint(0), null);

                    CloseSecureChannelRequest request = new CloseSecureChannelRequest(requestHeader);

                    ch.pipeline().fireUserEventTriggered(request);
                });

                return new DisconnectedState();

            case ConnectionLost:
                CompletableFuture<Channel> channelFuture = UaTcpClient.bootstrap(context.getClient());

                channelFuture.whenCompleteAsync((ch, ex) -> {
                    if (ch != null) {
                        context.handleEvent(ConnectionStateEvent.ConnectSuccess);
                    } else {
                        context.handleEvent(ConnectionStateEvent.ConnectFailure);
                    }
                }, context.getClient().getExecutorService());

                return new ReconnectingState(channelFuture);

            default:
                return context.getState();
        }
    }

    @Override
    public CompletableFuture<Channel> getChannelFuture() {
        return channelFuture;
    }

}
