package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaStructure;
import com.inductiveautomation.opcua.stack.core.types.UaDataType;
import com.inductiveautomation.opcua.stack.core.types.builtin.DateTime;
import com.inductiveautomation.opcua.stack.core.types.builtin.DiagnosticInfo;
import com.inductiveautomation.opcua.stack.core.types.builtin.ExtensionObject;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.builtin.StatusCode;
import com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaDataType("ResponseHeader")
public class ResponseHeader implements UaStructure {

    public static final NodeId TypeId = Identifiers.ResponseHeader;
    public static final NodeId BinaryEncodingId = Identifiers.ResponseHeader_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.ResponseHeader_Encoding_DefaultXml;

    protected final DateTime _timestamp;
    protected final UInteger _requestHandle;
    protected final StatusCode _serviceResult;
    protected final DiagnosticInfo _serviceDiagnostics;
    protected final String[] _stringTable;
    protected final ExtensionObject _additionalHeader;

    public ResponseHeader() {
        this._timestamp = null;
        this._requestHandle = null;
        this._serviceResult = null;
        this._serviceDiagnostics = null;
        this._stringTable = null;
        this._additionalHeader = null;
    }

    public ResponseHeader(DateTime _timestamp, UInteger _requestHandle, StatusCode _serviceResult, DiagnosticInfo _serviceDiagnostics, String[] _stringTable, ExtensionObject _additionalHeader) {
        this._timestamp = _timestamp;
        this._requestHandle = _requestHandle;
        this._serviceResult = _serviceResult;
        this._serviceDiagnostics = _serviceDiagnostics;
        this._stringTable = _stringTable;
        this._additionalHeader = _additionalHeader;
    }

    public DateTime getTimestamp() {
        return _timestamp;
    }

    public UInteger getRequestHandle() {
        return _requestHandle;
    }

    public StatusCode getServiceResult() {
        return _serviceResult;
    }

    public DiagnosticInfo getServiceDiagnostics() {
        return _serviceDiagnostics;
    }

    public String[] getStringTable() {
        return _stringTable;
    }

    public ExtensionObject getAdditionalHeader() {
        return _additionalHeader;
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


    public static void encode(ResponseHeader responseHeader, UaEncoder encoder) {
        encoder.encodeDateTime("Timestamp", responseHeader._timestamp);
        encoder.encodeUInt32("RequestHandle", responseHeader._requestHandle);
        encoder.encodeStatusCode("ServiceResult", responseHeader._serviceResult);
        encoder.encodeDiagnosticInfo("ServiceDiagnostics", responseHeader._serviceDiagnostics);
        encoder.encodeArray("StringTable", responseHeader._stringTable, encoder::encodeString);
        encoder.encodeExtensionObject("AdditionalHeader", responseHeader._additionalHeader);
    }

    public static ResponseHeader decode(UaDecoder decoder) {
        DateTime _timestamp = decoder.decodeDateTime("Timestamp");
        UInteger _requestHandle = decoder.decodeUInt32("RequestHandle");
        StatusCode _serviceResult = decoder.decodeStatusCode("ServiceResult");
        DiagnosticInfo _serviceDiagnostics = decoder.decodeDiagnosticInfo("ServiceDiagnostics");
        String[] _stringTable = decoder.decodeArray("StringTable", decoder::decodeString, String.class);
        ExtensionObject _additionalHeader = decoder.decodeExtensionObject("AdditionalHeader");

        return new ResponseHeader(_timestamp, _requestHandle, _serviceResult, _serviceDiagnostics, _stringTable, _additionalHeader);
    }

    static {
        DelegateRegistry.registerEncoder(ResponseHeader::encode, ResponseHeader.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(ResponseHeader::decode, ResponseHeader.class, BinaryEncodingId, XmlEncodingId);
    }

}
