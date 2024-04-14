package com.zerobyte.sharputil.data.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompoundDataTag extends BaseDataTag{
    private Map<String,DataTag> tags = new HashMap<>();

    public CompoundDataTag() {
    }

    public CompoundDataTag(Map<String, DataTag> tags) {
        this.tags = tags;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        for(String key : tags.keySet()){
            DataTag tag = tags.get(key);
            writeTags(key,tag,dataOutput);
        }
        dataOutput.writeByte(DataTag.END_DATA_TAG);
    }

    public static void writeTags(String key,DataTag tag,DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(tag.getType());
        if(tag.getType()!=0){
            dataOutput.writeUTF(key);
            tag.write(dataOutput);
        }
    }

    public static CompoundDataTag read(DataInput dataInput) throws IOException {
        Map<String, DataTag> map = new HashMap<>();
        byte b;
        while ((b = dataInput.readByte()) != 0){
            DataTag tag;
            String name;
            name = dataInput.readUTF();
            tag = DataTag.readTag(b,dataInput);
            if(name!=null&&tag!=null)
                map.put(name,tag);
        }
        return new CompoundDataTag(map);
    }

    public String getTagTree(){
        StringBuilder stringBuilder = new StringBuilder();
        tags.forEach((s, dataTag) -> {
            DataTag.getTagTreeNode(stringBuilder, dataTag,s);
        });
        return stringBuilder.toString();
    }

    @Override
    public byte getType() {
        return DataTag.COMPOUND_DATA_TAG;
    }

    @Override
    public Object getValue() {
        return tags;
    }

    public void putInt(String key, int v){
        IntDataTag tag = new IntDataTag(v);
        tags.put(key,tag);
    }

    public int getInt(String key){
        return ((IntDataTag) tags.get(key)).value;
    }

    public void put(String key,DataTag tag){
        tags.put(key,tag);
    }

    public DataTag get(String key){
        return tags.get(key);
    }

    public void putIntArray(String key,int[] v){
        IntArrayDataTag intArrayDataTag = new IntArrayDataTag(v);
        tags.put(key,intArrayDataTag);
    }

    public int[] getIntArray(String key){
        return ((IntArrayDataTag) tags.get(key)).value;
    }

    public void putString(String key,String value){
        StringDataTag stringDataTag = new StringDataTag(value);
        tags.put(key,stringDataTag);
    }

    public String getString(String key){
        return ((StringDataTag) tags.get(key)).value;
    }

    public void putBoolean(String key, boolean v){
        BooleanDataTag tag = new BooleanDataTag(v);
        tags.put(key,tag);
    }

    public boolean getBoolean(String key){
        return ((BooleanDataTag) tags.get(key)).value;
    }

    public void putLong(String key, long v){
        LongDataTag tag = new LongDataTag(v);
        tags.put(key,tag);
    }

    public long getLong(String key){
        return ((LongDataTag) tags.get(key)).value;
    }

    public void putFloat(String key, float v){
        FloatDataTag tag = new FloatDataTag(v);
        tags.put(key,tag);
    }

    public float getFloat(String key){
        return ((FloatDataTag) tags.get(key)).value;
    }

    public void putDouble(String key, double v){
        DoubleDataTag tag = new DoubleDataTag(v);
        tags.put(key,tag);
    }

    public double getDouble(String key){
        return ((DoubleDataTag) tags.get(key)).value;
    }

    public void putByte(String key, byte v){
        ByteDataTag tag = new ByteDataTag(v);
        tags.put(key,tag);
    }

    public byte getByte(String key){
        return ((ByteDataTag) tags.get(key)).value;
    }

    @Override
    public String toString() {
        return "";
    }
}
