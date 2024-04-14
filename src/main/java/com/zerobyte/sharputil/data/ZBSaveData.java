package com.zerobyte.sharputil.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;


public abstract class ZBSaveData {
    protected Consumer<ExceptionPacket> saveExceptionHandle;
    protected Consumer<ExceptionPacket> loadExceptionHandle;

    public ZBSaveData(Consumer<ExceptionPacket> saveExceptionHandle, Consumer<ExceptionPacket> loadExceptionHandle){
        this.saveExceptionHandle = saveExceptionHandle;
        this.loadExceptionHandle = loadExceptionHandle;
    }

    protected abstract void read(DataInputStream datainputstream,File file) throws IOException;
    protected abstract void write(DataOutputStream dataOutputStream,File file) throws IOException;

    protected final void save(String path,String name){
        File file = new File(path, name);
        try (
                OutputStream outputstream = Files.newOutputStream(file.toPath(), StandardOpenOption.SYNC, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                OutputStream outputstream1 = new BufferedOutputStream(outputstream);
                DataOutputStream dataoutputstream = new DataOutputStream(outputstream1)){
            write(dataoutputstream,file);
        } catch (IOException e) {
            saveExceptionHandle.accept(new ExceptionPacket(e,file));
        }
    }

    protected final void load(String path,String name){
        File file = new File(path, name);
        if(!file.exists()) {
            return;
        }
        try (
                InputStream inputstream = Files.newInputStream(file.toPath());
                DataInputStream datainputstream = new DataInputStream(inputstream)
        ) {
            read(datainputstream,file);
        } catch (IOException e) {
            loadExceptionHandle.accept(new ExceptionPacket(e,file));
        }
    }

    public record ExceptionPacket(Exception exception, File file) {

        @Override
        public Exception exception() {
            return exception;
        }

        @Override
        public File file() {
            return file;
        }
    }
}
