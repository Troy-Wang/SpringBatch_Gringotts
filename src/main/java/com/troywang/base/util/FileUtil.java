package com.troywang.base.util;

import java.io.File;

/**
 * util for file operation
 * Created by troywang on 2018/5/14.
 */
public class FileUtil {

    /**
     * check if file exists
     *
     * @param resource
     *
     * @return
     */
    public static boolean checkFileExistence(String resource) {
        File resrc = new File(resource);
        if (resrc.exists()) {
            return true;
        }
        return false;
    }
}
