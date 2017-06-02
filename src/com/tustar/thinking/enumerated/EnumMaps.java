package com.tustar.thinking.enumerated;

import com.tustar.thinking.enumerated.menu.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

import static com.tustar.thinking.enumerated.menu.AlarmPoints.*;

/**
 * Created by tustar on 17-6-2.
 */
interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));
        for (Map.Entry<AlarmPoints, Command> entry : em.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            entry.getValue().action();
        }
        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
