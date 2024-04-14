package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FloatDataTag extends BaseDataTag{
    public float value;

    public FloatDataTag(float value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(value);
    }

    public static FloatDataTag read(DataInput dataInput) throws IOException {
        return new FloatDataTag(dataInput.readFloat());
    }

    @Override
    public byte getType() {
        return FLOAT_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
