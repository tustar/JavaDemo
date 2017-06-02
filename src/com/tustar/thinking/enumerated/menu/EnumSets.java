package com.tustar.thinking.enumerated.menu;

import java.util.EnumSet;

import static com.tustar.thinking.enumerated.menu.AlarmPoints.*;

/**
 * Created by tustar on 17-6-2.
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints>  points = EnumSet.noneOf(AlarmPoints.class); // Empty set
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
