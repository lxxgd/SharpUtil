package com.zerobyte.sharputil.data.tag;

import com.zerobyte.sharputil.SharpUtil;

public class DataTagUtil {
    public static String getRootCompoundTagTagTree(String root,CompoundDataTag compoundDataTag){
        return root + "\n" + SharpUtil.addToLineHeader(compoundDataTag.getTagTree(),"├─","├─","└");
    }
}
