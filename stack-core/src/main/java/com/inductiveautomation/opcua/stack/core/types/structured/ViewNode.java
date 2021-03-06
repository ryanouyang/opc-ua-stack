package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.LocalizedText;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.builtin.QualifiedName;
import com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.UByte;
import com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.UInteger;
import com.inductiveautomation.opcua.stack.core.types.enumerated.NodeClass;

@UaDataType("ViewNode")
public class ViewNode extends InstanceNode {

    public static final NodeId TypeId = Identifiers.ViewNode;
    public static final NodeId BinaryEncodingId = Identifiers.ViewNode_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.ViewNode_Encoding_DefaultXml;

    protected final Boolean _containsNoLoops;
    protected final UByte _eventNotifier;

    public ViewNode() {
        super(null, null, null, null, null, null, null, null);
        this._containsNoLoops = null;
        this._eventNotifier = null;
    }

    public ViewNode(NodeId _nodeId, NodeClass _nodeClass, QualifiedName _browseName, LocalizedText _displayName, LocalizedText _description, UInteger _writeMask, UInteger _userWriteMask, ReferenceNode[] _references, Boolean _containsNoLoops, UByte _eventNotifier) {
        super(_nodeId, _nodeClass, _browseName, _displayName, _description, _writeMask, _userWriteMask, _references);
        this._containsNoLoops = _containsNoLoops;
        this._eventNotifier = _eventNotifier;
    }

    public Boolean getContainsNoLoops() {
        return _containsNoLoops;
    }

    public UByte getEventNotifier() {
        return _eventNotifier;
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


    public static void encode(ViewNode viewNode, UaEncoder encoder) {
        encoder.encodeNodeId("NodeId", viewNode._nodeId);
        encoder.encodeEnumeration("NodeClass", viewNode._nodeClass);
        encoder.encodeQualifiedName("BrowseName", viewNode._browseName);
        encoder.encodeLocalizedText("DisplayName", viewNode._displayName);
        encoder.encodeLocalizedText("Description", viewNode._description);
        encoder.encodeUInt32("WriteMask", viewNode._writeMask);
        encoder.encodeUInt32("UserWriteMask", viewNode._userWriteMask);
        encoder.encodeArray("References", viewNode._references, encoder::encodeSerializable);
        encoder.encodeBoolean("ContainsNoLoops", viewNode._containsNoLoops);
        encoder.encodeByte("EventNotifier", viewNode._eventNotifier);
    }

    public static ViewNode decode(UaDecoder decoder) {
        NodeId _nodeId = decoder.decodeNodeId("NodeId");
        NodeClass _nodeClass = decoder.decodeEnumeration("NodeClass", NodeClass.class);
        QualifiedName _browseName = decoder.decodeQualifiedName("BrowseName");
        LocalizedText _displayName = decoder.decodeLocalizedText("DisplayName");
        LocalizedText _description = decoder.decodeLocalizedText("Description");
        UInteger _writeMask = decoder.decodeUInt32("WriteMask");
        UInteger _userWriteMask = decoder.decodeUInt32("UserWriteMask");
        ReferenceNode[] _references = decoder.decodeArray("References", decoder::decodeSerializable, ReferenceNode.class);
        Boolean _containsNoLoops = decoder.decodeBoolean("ContainsNoLoops");
        UByte _eventNotifier = decoder.decodeByte("EventNotifier");

        return new ViewNode(_nodeId, _nodeClass, _browseName, _displayName, _description, _writeMask, _userWriteMask, _references, _containsNoLoops, _eventNotifier);
    }

    static {
        DelegateRegistry.registerEncoder(ViewNode::encode, ViewNode.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(ViewNode::decode, ViewNode.class, BinaryEncodingId, XmlEncodingId);
    }

}
