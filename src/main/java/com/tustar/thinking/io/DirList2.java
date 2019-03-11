package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by tustar on 17-5-10.
 */
public class DirList2 {

    public static void main(String[] args) {
        System.out.println(FileUtils.getSrcJavaPath(DirList.class));
        File path = new File(FileUtils.getSrcJavaPath(DirList.class));
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list((dir, name) -> Pattern.compile(args[0]).matcher(name).matches());
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }


}
