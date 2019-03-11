package com.tustar.utils;

/**
 * Created by tustar on 17-5-10.
 */
public class FileUtils {

    public static String getSrcJavaPath(Class<?> clazz) {
        return System.getProperty("user.dir") + "/src/" + clazz.getPackage().getName().replace(".", "/");
    }

    public static String getSrcJavaFilePath(Class<?> clazz, String filename) {
        return getSrcJavaPath(clazz) + "/" + filename;
    }
}
