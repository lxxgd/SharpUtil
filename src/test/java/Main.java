import com.zerobyte.sharputil.ExceptionUtil;
import com.zerobyte.sharputil.TextUtil;
import com.zerobyte.sharputil.data.tag.DataTagUtil;
import com.zerobyte.sharputil.logging.SimpleLogger;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static SimpleLogger LOGGER = new SimpleLogger("Main",System.getProperty("user.dir")+"\\logs");
    static boolean stopping;
    static int tickCount;

    static TestSaveData data = new TestSaveData(exceptionPackage -> {
        LOGGER.error(ExceptionUtil.getStackTrace(exceptionPackage.exception()));
    },exceptionPackage -> {
        LOGGER.error(ExceptionUtil.getStackTrace(exceptionPackage.exception()));
    });

    public static void main(String[] args){
        data.uuid.add(UUID.fromString("1edb436c-40b9-437d-9b67-80e12e833908"));
        data.uuid.add(UUID.fromString("5bb90d36-188f-4086-af9a-bb9c8a67f921"));
        data.uuid.add(UUID.fromString("5191497d-743f-4d19-89e8-2f9189327168"));
        data.anInt = 114514;
        data.anInt2 = 666;
        data.anInt3 = Integer.MAX_VALUE;
        data.string = "aaa";
        data.save();
        data = new TestSaveData(exceptionPackage -> {
            System.out.println(ExceptionUtil.getStackTrace(exceptionPackage.exception()));
        },exceptionPackage -> {
            System.out.println(ExceptionUtil.getStackTrace(exceptionPackage.exception()));
        });
        data.load();
        data.uuid.forEach(uuid -> {
            System.out.println(uuid.toString());
        });
        System.out.println(data.anInt);
        System.out.println(data.anInt2);
        System.out.println(data.anInt3);
        System.out.println(DataTagUtil.getRootCompoundTagTagTree("data.compoundDataTag1",data.compoundDataTag1));
        DecimalFormat df = new DecimalFormat("#");
        df.setParseBigDecimal(false);
        String Double_MAX_VALUE = df.format(Double.MAX_VALUE);
        System.out.println("完整的Double.MAX_VALUE：\n"+Double_MAX_VALUE+"\n长达"+Double_MAX_VALUE.length()+"位！");
        String Float_MAX_VALUE = df.format(Float.MAX_VALUE);
        System.out.println("Float.MAX_VALUE：\n"+Float_MAX_VALUE+"\n长达"+Float_MAX_VALUE.length()+"位！");
        System.out.println(TextUtil.Formatting("114514",new String[]{","},10));
        LOGGER.info("AAA");
        LOGGER.info(System.getProperty("user.dir"));
        System.out.println(TextUtil.PrintDirectory("F:\\sp\\SharpUtil\\Test"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stopping){
                  loop();
                }
            }
        },"loop");
        thread.start();
    }

    private static void loop(){
        tickCount++;
        if(tickCount>=60){
            tickCount = 0;
        }
        try {
            TimeUnit.MICROSECONDS.sleep(16667);
        } catch (InterruptedException e) {
            LOGGER.error(ExceptionUtil.getStackTrace(e));
        }
    }
}
