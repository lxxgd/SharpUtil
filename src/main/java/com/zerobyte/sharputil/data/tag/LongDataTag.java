package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class LongDataTag extends BaseDataTag{
    public long value;

    public LongDataTag(long value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(value);
    }

    public static LongDataTag read(DataInput dataInput) throws IOException {
        return new LongDataTag(dataInput.readLong());
    }

    @Override
    public byte getType() {
        return LONG_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
