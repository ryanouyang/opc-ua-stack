package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.ByteString;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;

@UaDataType("DeleteEventDetails")
public class DeleteEventDetails extends HistoryUpdateDetails {

    public static final NodeId TypeId = Identifiers.DeleteEventDetails;
    public static final NodeId BinaryEncodingId = Identifiers.DeleteEventDetails_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.DeleteEventDetails_Encoding_DefaultXml;

    protected final ByteString[] _eventIds;

    public DeleteEventDetails() {
        super(null);
        this._eventIds = null;
    }

    public DeleteEventDetails(NodeId _nodeId, ByteString[] _eventIds) {
        super(_nodeId);
        this._eventIds = _eventIds;
    }

    public ByteString[] getEventIds() {
        return _eventIds;
    }

    @Override
    public NodeId getTypeId() {
        return TypeId;
    }

    @Override
    public NodeId getBinaryEncodingId() {
        return BinaryEncodingId;
    }

    @Override
    public NodeId getXmlEncodingId() {
        return XmlEncodingId;
    }


    public static void encode(DeleteEventDetails deleteEventDetails, UaEncoder encoder) {
        encoder.encodeNodeId("NodeId", deleteEventDetails._nodeId);
        encoder.encodeArray("EventIds", deleteEventDetails._eventIds, encoder::encodeByteString);
    }

    public static DeleteEventDetails decode(UaDecoder decoder) {
        NodeId _nodeId = decoder.decodeNodeId("NodeId");
        ByteString[] _eventIds = decoder.decodeArray("EventIds", decoder::decodeByteString, ByteString.class);

        return new DeleteEventDetails(_nodeId, _eventIds);
    }

    static {
        DelegateRegistry.registerEncoder(DeleteEventDetails::encode, DeleteEventDetails.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(DeleteEventDetails::decode, DeleteEventDetails.class, BinaryEncodingId, XmlEncodingId);
    }

}
