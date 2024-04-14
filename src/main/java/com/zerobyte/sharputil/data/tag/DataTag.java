package com.zerobyte.sharputil.data.tag;

import com.zerobyte.sharputil.SharpUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public interface DataTag {
    byte END_DATA_TAG = 0;
    byte COMPOUND_DATA_TAG = 1;
    byte INT_DATA_TAG = 2;
    byte INT_ARRAY_DATA_TAG = 3;
    byte LIST_DATA_TAG = 4;
    byte STRING_DATA_TAG = 5;
    byte BOOLEAN_DATA_TAG = 6;
    byte LONG_DATA_TAG = 7;
    byte FLOAT_DATA_TAG = 8;
    byte DOUBLE_DATA_TAG = 9;
    byte BYTE_DATA_TAG = 10;

    void write(DataOutput dataOutput) throws IOException;
    byte getType();
    Object getValue();

    static DataTag readTag(byte b, DataInput dataInput) throws IOException {
        DataTag tag = null;
        if(b == COMPOUND_DATA_TAG){
            tag = CompoundDataTag.read(dataInput);
        }else if(b == INT_DATA_TAG){
            tag = IntDataTag.read(dataInput);
        } else if (b == INT_ARRAY_DATA_TAG) {
            tag = IntArrayDataTag.read(dataInput);
        }else if (b == LIST_DATA_TAG) {
            tag = ListDataTag.read(dataInput);
        } else if (b == STRING_DATA_TAG) {
            tag = StringDataTag.read(dataInput);
        } else if (b == BOOLEAN_DATA_TAG) {
            tag = BooleanDataTag.read(dataInput);
        } else if (b == LONG_DATA_TAG) {
            tag = LongDataTag.read(dataInput);
        } else if (b == FLOAT_DATA_TAG) {
            tag = FloatDataTag.read(dataInput);
        } else if (b == DOUBLE_DATA_TAG) {
            tag = DoubleDataTag.read(dataInput);
        } else if (b == BYTE_DATA_TAG) {
            tag = ByteDataTag.read(dataInput);
        }
        return tag;
    }

    static void getTagTreeNode(StringBuilder stringBuilder, DataTag dataTag,String name) {
        if(name!=null)
            stringBuilder.append("[").append(dataTag.getClass().getSimpleName()).append("] ").append(name).append(" ").append(dataTag).append("\n");
        else
            stringBuilder.append("[").append(dataTag.getClass().getSimpleName()).append("] ").append(dataTag).append("\n");
        if(dataTag.getType()==DataTag.COMPOUND_DATA_TAG){
            String string = ((CompoundDataTag)dataTag).getTagTree();
            stringBuilder.append(SharpUtil.addToLineHeader(string,"───"));
        } else if (dataTag.getType() == DataTag.LIST_DATA_TAG) {
            String string = ((ListDataTag)dataTag).getTagTree();
            stringBuilder.append(SharpUtil.addToLineHeader(string,"───"));
        }
    }
}
