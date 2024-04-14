import com.zerobyte.sharputil.UUIDUtil;
import com.zerobyte.sharputil.data.*;
import com.zerobyte.sharputil.data.tag.CompoundDataTag;
import com.zerobyte.sharputil.data.tag.ListDataTag;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class TestSaveData extends ZBSaveData {
    public final List<UUID> uuid = new ArrayList<>();
    public int anInt;
    public int anInt2;
    public int anInt3;
    public CompoundDataTag compoundDataTag1;
    public CompoundDataTag compoundDataTag2;
    public String string;

    public TestSaveData(Consumer<ExceptionPacket> saveExceptionHandle, Consumer<ExceptionPacket> loadExceptionHandle) {
        super(saveExceptionHandle, loadExceptionHandle);
    }

    @Override
    protected void read(DataInputStream datainputstream, File file) throws IOException {
        CompoundDataTag compoundDataTag = CompoundDataTag.read(datainputstream);
//        for (String key : compoundDataTag.tags.keySet()){
//            if (key.startsWith("UUID-")) {
//                IntArrayDataTag dataTag = (IntArrayDataTag) compoundDataTag.tags.get(key);
//                UUID uuid1 = UUIDUtil.uuidFromIntArray(dataTag.value);
//                uuid.add(uuid1);
//            }
//        }
        ListDataTag listDataTag = (ListDataTag) compoundDataTag.get("uuid");
        listDataTag.tagList.forEach(dataTag -> {
            UUID uuid1 = UUIDUtil.uuidFromIntArray(((CompoundDataTag)dataTag).getIntArray("UUID"));
            uuid.add(uuid1);
        });
        compoundDataTag1 = compoundDataTag;
        compoundDataTag2 = (CompoundDataTag) compoundDataTag.get("WOW");
        anInt = compoundDataTag.getInt("int");
        anInt2 = compoundDataTag.getInt("int2");
        anInt3 = compoundDataTag.getInt("int3");
        string = compoundDataTag.getString("str");
    }

    @Override
    protected void write(DataOutputStream dataOutputStream, File file) throws IOException {
        CompoundDataTag compoundDataTag = new CompoundDataTag();
        ListDataTag listDataTag = new ListDataTag();
        uuid.forEach(uuid1 -> {
            int[] b = UUIDUtil.uuidToIntArray(uuid1);
//            for(int i : b){
//                System.out.println(i);
//            }
            CompoundDataTag compoundDataTag3 = new CompoundDataTag();
            compoundDataTag3.putIntArray("UUID",b);
            listDataTag.tagList.add(compoundDataTag3);
        });
        compoundDataTag.putInt("int",anInt);
        compoundDataTag.putInt("int2",anInt2);
        compoundDataTag.putInt("int3",anInt3);
        CompoundDataTag compoundDataTag1 = new CompoundDataTag();
        compoundDataTag1.putInt("AN",741);
        compoundDataTag.put("WOW",compoundDataTag1);
        compoundDataTag.put("uuid",listDataTag);
        compoundDataTag.putString("str",string);
        compoundDataTag.putLong("long!",Long.MAX_VALUE);
        compoundDataTag.putDouble("double!",Double.MAX_VALUE);
        compoundDataTag.putFloat("Float!",Float.MAX_VALUE);
        compoundDataTag.putBoolean("Boolean!",true);
        compoundDataTag.putByte("Byte!",Byte.MAX_VALUE);
        compoundDataTag.write(dataOutputStream);
    }

    public void save(){
        super.save(System.getProperty("user.dir"),"test");
    }

    public void load(){
        super.load(System.getProperty("user.dir"),"test");
    }
}
