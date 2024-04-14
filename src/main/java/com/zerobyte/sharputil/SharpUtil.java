package com.zerobyte.sharputil;

import java.util.Arrays;
import java.util.List;

public class SharpUtil {
    public static boolean debugInfo;

    public static String addToLineHeader(String string,String symbol){
        String[] strings = string.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String s = symbol + strings[i];
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String addToLineHeader(String str,String symbol,String start,String end){
        String[] strings = str.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String s;
            if(i==0)
               s = start + strings[i];
            else if (i== strings.length-1)
                s = end + strings[i];
            else
                s = start + strings[i];
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }
}
