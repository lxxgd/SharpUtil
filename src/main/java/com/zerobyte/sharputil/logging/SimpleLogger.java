package com.zerobyte.sharputil.logging;

import com.zerobyte.sharputil.ExceptionUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleLogger {
    private final String name;
    private final String path;
    private final String fileName;
    private final StringBuilder historyLog;

    public SimpleLogger(String name, String path) {
        this.name = name;
        this.path = path;
        this.fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-M-d--HH-mm-ss"))+ ".log";
        this.historyLog = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public String getHistoryLog() {
        return historyLog.toString();
    }

    public String log(String msg, LogLevel level){
        File file = new File(path,fileName);

        if(!file.exists()){
            try {
                new File(path).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(ExceptionUtil.getStackTrace(e));
            }
        }
        String str = "["+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss")) + "] "
                + "[" + Thread.currentThread().getName() + "/" + name + "] "
                + "[" + level.name() + "] "
                + msg;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
                bufferedWriter.write(str+"\n");
        }catch (IOException e){
            System.out.println(ExceptionUtil.getStackTrace(e));
        }
        System.out.println(str);
        historyLog.append(str).append("\n");
        return str;
    }

    public String log(Object o,LogLevel level){
        return log(o.toString(),level);
    }

    public String log(String s,LogLevel level,Object... args){
        return log(String.format(s,args),level);
    }

    public String debug(String string){
        return log(string,LogLevel.DEBUG);
    }

    public String debug(Object o){
        return debug(o.toString());
    }

    public String debug(String s,Object... args){
        return debug(String.format(s,args));
    }

    public String info(String string){
        return log(string,LogLevel.INFO);
    }

    public String info(Object o){
        return info(o.toString());
    }

    public String info(String s,Object... args){
        return info(String.format(s,args));
    }

    public String warn(String string){
        return log(string,LogLevel.WARN);
    }

    public String warn(Object o){
        return warn(o.toString());
    }

    public String warn(String s,Object... args){
        return warn(String.format(s,args));
    }

    public String error(String s){
        return log(s,LogLevel.ERROR);
    }

    public String error(Object o){
        return error(o.toString());
    }

    public String error(String s,Object... args){
        return error(String.format(s,args));
    }

    public String fail(String s){
        return log(s,LogLevel.FAIL);
    }

    public String fail(Object o){
        return fail(o.toString());
    }

    public String fail(String s,Object... args){
        return fail(String.format(s,args));
    }
}
