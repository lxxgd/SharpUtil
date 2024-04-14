package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class IntArrayDataTag extends BaseDataTag {
    public int[] value;

    public IntArrayDataTag(int[] value) {
        this.value = value;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(value.length);
        for(int i : value){
            System.out.println(i);
            dataOutput.writeInt(i);
        }
    }

    public static IntArrayDataTag read(DataInput dataInput) throws IOException {
        int length = dataInput.readInt();
        int[] v = new int[length];
        for(int j = 0; j < length; j++) {
            v[j] = dataInput.readInt();
        }
        return new IntArrayDataTag(v);
    }

    @Override
    public byte getType() {
        return DataTag.INT_ARRAY_DATA_TAG;
    }

    @Override
    public Object getValue() {
        List<Integer> list = new ArrayList<>();
        for (int i : value){
            list.add(i);
        }
        return list;
    }
}
