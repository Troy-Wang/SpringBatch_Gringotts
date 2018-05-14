package com.troywang.base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * util for class operation
 * Created by troywang on 2018/5/14.
 */
public class ClassUtil {

    /**
     * get all class member names
     *
     * @param type
     *
     * @return
     */
    public static String[] getClassMemberList(Class type) {
        ArrayList<String> classMemberList = new ArrayList<String>();
        for (Field f : type.getDeclaredFields()) {
            classMemberList.add(f.getName());
        }
        return classMemberList.toArray(new String[classMemberList.size()]);
    }
}
