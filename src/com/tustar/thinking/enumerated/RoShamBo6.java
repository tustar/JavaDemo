package com.tustar.thinking.enumerated;

import static com.tustar.thinking.enumerated.Outcome.*;

/**
 * Created by tustar on 17-6-5.
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static Outcome[][] table = {
            {DRAW, LOST, WIN}, // PAPER
            {WIN, DRAW, LOST}, // SCISSORS
            {LOST, WIN, DRAW}, // ROCK
    };

    @Override
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
