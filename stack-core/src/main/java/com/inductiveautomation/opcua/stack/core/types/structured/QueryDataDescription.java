package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaStructure;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaDataType("QueryDataDescription")
public class QueryDataDescription implements UaStructure {

    public static final NodeId TypeId = Identifiers.QueryDataDescription;
    public static final NodeId BinaryEncodingId = Identifiers.QueryDataDescription_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.QueryDataDescription_Encoding_DefaultXml;

    protected final RelativePath _relativePath;
    protected final UInteger _attributeId;
    protected final String _indexRange;

    public QueryDataDescription() {
        this._relativePath = null;
        this._attributeId = null;
        this._indexRange = null;
    }

    public QueryDataDescription(RelativePath _relativePath, UInteger _attributeId, String _indexRange) {
        this._relativePath = _relativePath;
        this._attributeId = _attributeId;
        this._indexRange = _indexRange;
    }

    public RelativePath getRelativePath() {
        return _relativePath;
    }

    public UInteger getAttributeId() {
        return _attributeId;
    }

    public String getIndexRange() {
        return _indexRange;
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


    public static void encode(QueryDataDescription queryDataDescription, UaEncoder encoder) {
        encoder.encodeSerializable("RelativePath", queryDataDescription._relativePath != null ? queryDataDescription._relativePath : new RelativePath());
        encoder.encodeUInt32("AttributeId", queryDataDescription._attributeId);
        encoder.encodeString("IndexRange", queryDataDescription._indexRange);
    }

    public static QueryDataDescription decode(UaDecoder decoder) {
        RelativePath _relativePath = decoder.decodeSerializable("RelativePath", RelativePath.class);
        UInteger _attributeId = decoder.decodeUInt32("AttributeId");
        String _indexRange = decoder.decodeString("IndexRange");

        return new QueryDataDescription(_relativePath, _attributeId, _indexRange);
    }

    static {
        DelegateRegistry.registerEncoder(QueryDataDescription::encode, QueryDataDescription.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(QueryDataDescription::decode, QueryDataDescription.class, BinaryEncodingId, XmlEncodingId);
    }

}
