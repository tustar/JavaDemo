package com.tustar.thinking.typeinfo;

/**
 * Created by tustar on 17-5-22.
 */
class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b;
    }
}
