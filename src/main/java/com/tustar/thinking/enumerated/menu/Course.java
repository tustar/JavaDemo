package com.tustar.thinking.enumerated.menu;

import com.tustar.thinking.util.Enums;

/**
 * Created by tustar on 17-5-9.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] valeus;

    private Course(Class<? extends Food> kind) {
        valeus = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(valeus);
    }
}
