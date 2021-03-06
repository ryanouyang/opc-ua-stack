package com.inductiveautomation.opcua.stack.core.channel;

import java.security.KeyPair;
import java.security.cert.X509Certificate;
import java.util.List;

import com.google.common.base.Objects;
import com.inductiveautomation.opcua.stack.core.UaException;
import com.inductiveautomation.opcua.stack.core.security.SecurityPolicy;
import com.inductiveautomation.opcua.stack.core.types.builtin.ByteString;
import com.inductiveautomation.opcua.stack.core.types.enumerated.MessageSecurityMode;
import com.inductiveautomation.opcua.stack.core.types.structured.EndpointDescription;
import com.inductiveautomation.opcua.stack.core.util.CertificateUtil;
import io.netty.util.DefaultAttributeMap;

public class ServerSecureChannel extends DefaultAttributeMap implements SecureChannel {

    private volatile long channelId = 0;
    private volatile ChannelSecurity channelSecurity;
    private volatile ByteString localNonce = ByteString.NULL_VALUE;
    private volatile ByteString remoteNonce = ByteString.NULL_VALUE;

    private volatile KeyPair keyPair;
    private volatile X509Certificate localCertificate;

    private volatile X509Certificate remoteCertificate;
    private volatile List<X509Certificate> remoteCertificateChain;

    private volatile SecurityPolicy securityPolicy;
    private volatile MessageSecurityMode messageSecurityMode;
    private volatile EndpointDescription endpointDescription;

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public void setLocalNonce(ByteString localNonce) {
        this.localNonce = localNonce;
    }

    public void setRemoteNonce(ByteString remoteNonce) {
        this.remoteNonce = remoteNonce;
    }

    public void setChannelSecurity(ChannelSecurity channelSecurity) {
        this.channelSecurity = channelSecurity;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public void setLocalCertificate(X509Certificate localCertificate) {
        this.localCertificate = localCertificate;
    }

    public void setRemoteCertificate(byte[] certificateBytes) throws UaException {
        remoteCertificate = CertificateUtil.decodeCertificate(certificateBytes);
        remoteCertificateChain = CertificateUtil.decodeCertificates(certificateBytes);
    }

    public void setSecurityPolicy(SecurityPolicy securityPolicy) {
        this.securityPolicy = securityPolicy;
    }

    public void setMessageSecurityMode(MessageSecurityMode messageSecurityMode) {
        this.messageSecurityMode = messageSecurityMode;
    }

    public void setEndpointDescription(EndpointDescription endpointDescription) {
        this.endpointDescription = endpointDescription;
    }

    public EndpointDescription getEndpointDescription() {
        return endpointDescription;
    }

    @Override
    public KeyPair getKeyPair() {
        return keyPair;
    }

    @Override
    public X509Certificate getLocalCertificate() {
        return localCertificate;
    }

    @Override
    public X509Certificate getRemoteCertificate() {
        return remoteCertificate;
    }

    @Override
    public List<X509Certificate> getRemoteCertificateChain() {
        return remoteCertificateChain;
    }

    @Override
    public SecurityPolicy getSecurityPolicy() {
        return securityPolicy;
    }

    @Override
    public MessageSecurityMode getMessageSecurityMode() {
        return messageSecurityMode;
    }

    @Override
    public long getChannelId() {
        return channelId;
    }

    @Override
    public ChannelSecurity getChannelSecurity() {
        return channelSecurity;
    }

    @Override
    public ChannelSecurity.SecretKeys getEncryptionKeys(ChannelSecurity.SecuritySecrets secretKeys) {
        return secretKeys.getServerKeys();
    }

    @Override
    public ChannelSecurity.SecretKeys getDecryptionKeys(ChannelSecurity.SecuritySecrets secretKeys) {
        return secretKeys.getClientKeys();
    }

    @Override
    public ByteString getLocalNonce() {
        return localNonce;
    }

    @Override
    public ByteString getRemoteNonce() {
        return remoteNonce;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("channelId", channelId)
                .add("securityPolicy", securityPolicy)
                .toString();
    }

}
