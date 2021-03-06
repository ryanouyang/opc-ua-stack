package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaStructure;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;

@UaDataType("NotificationData")
public class NotificationData implements UaStructure {

    public static final NodeId TypeId = Identifiers.NotificationData;
    public static final NodeId BinaryEncodingId = Identifiers.NotificationData_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.NotificationData_Encoding_DefaultXml;


    public NotificationData() {
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


    public static void encode(NotificationData notificationData, UaEncoder encoder) {
    }

    public static NotificationData decode(UaDecoder decoder) {

        return new NotificationData();
    }

    static {
        DelegateRegistry.registerEncoder(NotificationData::encode, NotificationData.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(NotificationData::decode, NotificationData.class, BinaryEncodingId, XmlEncodingId);
    }

}
