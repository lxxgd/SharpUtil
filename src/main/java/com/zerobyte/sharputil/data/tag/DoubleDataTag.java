package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DoubleDataTag extends BaseDataTag{
    public double value;

    public DoubleDataTag(double value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(value);
    }

    public static DoubleDataTag read(DataInput dataInput) throws IOException {
        return new DoubleDataTag(dataInput.readDouble());
    }

    @Override
    public byte getType() {
        return DOUBLE_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
