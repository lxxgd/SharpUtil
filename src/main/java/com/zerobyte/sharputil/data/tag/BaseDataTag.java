package com.zerobyte.sharputil.data.tag;

public abstract class BaseDataTag implements DataTag{
    @Override
    public String toString() {
        return "value:" + getValue();
    }
}
