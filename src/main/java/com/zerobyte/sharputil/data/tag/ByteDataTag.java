package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ByteDataTag extends BaseDataTag{
    public byte value;

    public ByteDataTag(byte value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(value);
    }

    public static ByteDataTag read(DataInput dataInput) throws IOException {
        return new ByteDataTag(dataInput.readByte());
    }

    @Override
    public byte getType() {
        return BYTE_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
