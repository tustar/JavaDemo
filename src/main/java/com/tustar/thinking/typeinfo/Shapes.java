package com.tustar.thinking.typeinfo;

import sun.security.provider.SHA;

import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tustar on 17-5-22.
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape: shapes) {
            shape.draw();
        }
    }
}
