package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class BooleanDataTag extends BaseDataTag{
    public boolean value;

    public BooleanDataTag(boolean value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(value);
    }

    public static BooleanDataTag read(DataInput dataInput) throws IOException {
        return new BooleanDataTag(dataInput.readBoolean());
    }

    @Override
    public byte getType() {
        return BOOLEAN_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
