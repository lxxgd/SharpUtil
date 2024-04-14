package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class IntDataTag extends BaseDataTag {
    public int value;

    public IntDataTag(int value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(value);
    }

    public static IntDataTag read(DataInput dataInput) throws IOException {
        return new IntDataTag(dataInput.readInt());
    }

    @Override
    public byte getType() {
        return DataTag.INT_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
