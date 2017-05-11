package com.tustar.thinking.io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * Created by tustar on 17-5-11.
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charset = Charset.availableCharsets();
        Iterator<String> iterator = charset.keySet().iterator();
        while (iterator.hasNext()) {
            String csName = iterator.next();
            System.out.print(csName);
            Iterator aliases = charset.get(csName).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(": ");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
