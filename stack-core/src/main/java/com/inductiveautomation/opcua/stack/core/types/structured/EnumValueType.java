package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaStructure;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.LocalizedText;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;

@UaDataType("EnumValueType")
public class EnumValueType implements UaStructure {

    public static final NodeId TypeId = Identifiers.EnumValueType;
    public static final NodeId BinaryEncodingId = Identifiers.EnumValueType_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.EnumValueType_Encoding_DefaultXml;

    protected final Long _value;
    protected final LocalizedText _displayName;
    protected final LocalizedText _description;

    public EnumValueType() {
        this._value = null;
        this._displayName = null;
        this._description = null;
    }

    public EnumValueType(Long _value, LocalizedText _displayName, LocalizedText _description) {
        this._value = _value;
        this._displayName = _displayName;
        this._description = _description;
    }

    public Long getValue() {
        return _value;
    }

    public LocalizedText getDisplayName() {
        return _displayName;
    }

    public LocalizedText getDescription() {
        return _description;
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


    public static void encode(EnumValueType enumValueType, UaEncoder encoder) {
        encoder.encodeInt64("Value", enumValueType._value);
        encoder.encodeLocalizedText("DisplayName", enumValueType._displayName);
        encoder.encodeLocalizedText("Description", enumValueType._description);
    }

    public static EnumValueType decode(UaDecoder decoder) {
        Long _value = decoder.decodeInt64("Value");
        LocalizedText _displayName = decoder.decodeLocalizedText("DisplayName");
        LocalizedText _description = decoder.decodeLocalizedText("Description");

        return new EnumValueType(_value, _displayName, _description);
    }

    static {
        DelegateRegistry.registerEncoder(EnumValueType::encode, EnumValueType.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(EnumValueType::decode, EnumValueType.class, BinaryEncodingId, XmlEncodingId);
    }

}
