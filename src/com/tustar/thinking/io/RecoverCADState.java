package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tustar on 17-5-16.
 */
public class RecoverCADState {
    private static String file = FileUtils.getSrcJavaFilePath(StoreCADState.class, "StoreCADState.out");
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        // Read in the same order they were written:
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
