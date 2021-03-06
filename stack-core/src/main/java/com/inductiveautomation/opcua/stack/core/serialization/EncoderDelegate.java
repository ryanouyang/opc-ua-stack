package com.inductiveautomation.opcua.stack.core.serialization;

public interface EncoderDelegate<T extends UaSerializable> {
    void encode(T encodable, UaEncoder encoder);
}
