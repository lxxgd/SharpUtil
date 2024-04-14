package com.zerobyte.sharputil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectHelper {
    public static void InvokeMethod(String s,Object o,Class<?> c,Object... p){
        try {

            Method method = c.getDeclaredMethod(s);
            method.setAccessible(true);
            method.invoke(o,p);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
        }
    }

    public static void InvokeMethod(String s,Object o,Class<?> c,Class<?>[] pt,Object... p){
        try {

            Method method = c.getDeclaredMethod(s,pt);
            method.setAccessible(true);
            method.invoke(o,p);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
        }
    }

    public static Object InvokeMethodWithReturn(String s,Object o,Class<?> c,Object... p){
        try {

            Method method = c.getDeclaredMethod(s);
            method.setAccessible(true);
            return method.invoke(o,p);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
            return null;
        }
    }

    public static Object InvokeMethodWithReturn(String s,Object o,Class<?> c,Class<?>[] pt,Object... p){
        try {

            Method method = c.getDeclaredMethod(s,pt);
            method.setAccessible(true);
            return method.invoke(o,p);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
            return null;
        }
    }

    public static void SetFiledValue(String s,Object o,Object v,Class<?> c){
        try {
            Field field = c.getDeclaredField(s);
            field.setAccessible(true);
            field.set(o,v);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
        }
    }

    public static Object GetFiledValue(String s,Object o,Class<?> c){
        try {

            Field field = c.getDeclaredField(s);
            field.setAccessible(true);
            return field.get(o);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
            return null;
        }
    }
}
