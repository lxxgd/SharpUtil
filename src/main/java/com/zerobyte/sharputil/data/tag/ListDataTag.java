package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListDataTag extends BaseDataTag{
    public List<DataTag> tagList;

    public ListDataTag(List<DataTag> tagList) {
        this.tagList = tagList;
    }

    public ListDataTag(){
        tagList = new ArrayList<>();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(tagList.size());
        for (DataTag tag : tagList){
            dataOutput.writeByte(tag.getType());
            if(tag.getType()!=0){
                tag.write(dataOutput);
            }
        }
    }

    public static ListDataTag read(DataInput dataInput) throws IOException{
        int size = dataInput.readInt();
        List<DataTag> tagList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            DataTag tag;
            byte b = dataInput.readByte();
            tag = DataTag.readTag(b,dataInput);
            if(tag!=null)
                tagList.add(tag);
        }
        return new ListDataTag(tagList);
    }

    public String getTagTree(){
        StringBuilder stringBuilder = new StringBuilder();
        tagList.forEach(dataTag -> {
            DataTag.getTagTreeNode(stringBuilder, dataTag,null);
        });
        return stringBuilder.toString();
    }

    @Override
    public byte getType() {
        return LIST_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return tagList;
    }

    @Override
    public String toString() {
        return "";
    }
}
