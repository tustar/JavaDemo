package com.tustar.thinking.io;

import com.tustar.utils.FileUtils;
import sun.security.provider.SHA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tustar on 17-5-16.
 */
abstract class Shape implements Serializable {
    public static final int RED = 1, BULE = 2, GREEN = 3;
    private int x, y, dimension;
    private static Random random = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int x, int y, int dimension) {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + "{" +
                "x=" + x +
                ", y=" + y +
                ", dimension=" + dimension +
                ", color=" + getColor() +
                "}\n";
    }

    public static Shape randomFacotry() {
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        int dimens = random.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(x, y, dimens);
            case 1:
                return new Square(x, y, dimens);
            case 2:
                return new Line(x, y, dimens);
        }
    }
}

class Circle extends Shape {

    private static int color = RED;

    public Circle(int x, int y, int dimension) {
        super(x, y, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    public Square(int x, int y, int dimension) {
        super(x, y, dimension);
        color = RED;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {

    private static int color = RED;

    public Line(int x, int y, int dimension) {
        super(x, y, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }

    public static void serializeStaticState(ObjectOutputStream out) throws IOException {
        out.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream in) throws IOException {
        color = in.readInt();
    }
}

public class StoreCADState {
    private static String file = FileUtils.getSrcJavaFilePath(StoreCADState.class, "StoreCADState.out");

    public static void main(String[] args) throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        // Add references to the class objects:
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);
        List<Shape> shapes = new ArrayList<>();
        // Make some shapes:
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFacotry());
        }
        // Set all the static colors to GREEN:
        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }
        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        // Display the shapes:
        System.out.println(shapes);
    }
}
