package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StringDataTag extends BaseDataTag{
    public String value;

    public StringDataTag(String value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(value);
    }

    public static StringDataTag read(DataInput dataInput) throws IOException {
        return new StringDataTag(dataInput.readUTF());
    }

    @Override
    public byte getType() {
        return STRING_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
