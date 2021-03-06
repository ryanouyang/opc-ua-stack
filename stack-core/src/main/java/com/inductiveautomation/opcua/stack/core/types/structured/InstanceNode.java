package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.LocalizedText;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.builtin.QualifiedName;
import com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.UInteger;
import com.inductiveautomation.opcua.stack.core.types.enumerated.NodeClass;

@UaDataType("InstanceNode")
public class InstanceNode extends Node {

    public static final NodeId TypeId = Identifiers.InstanceNode;
    public static final NodeId BinaryEncodingId = Identifiers.InstanceNode_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.InstanceNode_Encoding_DefaultXml;


    public InstanceNode() {
        super(null, null, null, null, null, null, null, null);
    }

    public InstanceNode(NodeId _nodeId, NodeClass _nodeClass, QualifiedName _browseName, LocalizedText _displayName, LocalizedText _description, UInteger _writeMask, UInteger _userWriteMask, ReferenceNode[] _references) {
        super(_nodeId, _nodeClass, _browseName, _displayName, _description, _writeMask, _userWriteMask, _references);
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


    public static void encode(InstanceNode instanceNode, UaEncoder encoder) {
        encoder.encodeNodeId("NodeId", instanceNode._nodeId);
        encoder.encodeEnumeration("NodeClass", instanceNode._nodeClass);
        encoder.encodeQualifiedName("BrowseName", instanceNode._browseName);
        encoder.encodeLocalizedText("DisplayName", instanceNode._displayName);
        encoder.encodeLocalizedText("Description", instanceNode._description);
        encoder.encodeUInt32("WriteMask", instanceNode._writeMask);
        encoder.encodeUInt32("UserWriteMask", instanceNode._userWriteMask);
        encoder.encodeArray("References", instanceNode._references, encoder::encodeSerializable);
    }

    public static InstanceNode decode(UaDecoder decoder) {
        NodeId _nodeId = decoder.decodeNodeId("NodeId");
        NodeClass _nodeClass = decoder.decodeEnumeration("NodeClass", NodeClass.class);
        QualifiedName _browseName = decoder.decodeQualifiedName("BrowseName");
        LocalizedText _displayName = decoder.decodeLocalizedText("DisplayName");
        LocalizedText _description = decoder.decodeLocalizedText("Description");
        UInteger _writeMask = decoder.decodeUInt32("WriteMask");
        UInteger _userWriteMask = decoder.decodeUInt32("UserWriteMask");
        ReferenceNode[] _references = decoder.decodeArray("References", decoder::decodeSerializable, ReferenceNode.class);

        return new InstanceNode(_nodeId, _nodeClass, _browseName, _displayName, _description, _writeMask, _userWriteMask, _references);
    }

    static {
        DelegateRegistry.registerEncoder(InstanceNode::encode, InstanceNode.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(InstanceNode::decode, InstanceNode.class, BinaryEncodingId, XmlEncodingId);
    }

}
