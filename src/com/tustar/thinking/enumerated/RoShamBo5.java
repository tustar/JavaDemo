package com.tustar.thinking.enumerated;

import javafx.print.*;

import java.util.EnumMap;

import static com.tustar.thinking.enumerated.Outcome.*;

/**
 * Created by tustar on 17-6-5.
 */
public enum  RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<>(RoShamBo5.class);
    static {
        for (RoShamBo5 it: RoShamBo5.values()) {
            table.put(it, new EnumMap<>(RoShamBo5.class));
            initRow(PAPER, DRAW, LOST, WIN);
            initRow(SCISSORS, WIN, DRAW, LOST);
            initRow(ROCK, LOST, WIN, DRAW);
        }
    }

    static void initRow(RoShamBo5 it, Outcome vPaper, Outcome vScissor, Outcome vRock) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(PAPER, vPaper);
        row.put(SCISSORS, vScissor);
        row.put(ROCK, vRock);
    }

    @Override
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}
