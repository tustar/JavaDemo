package com.tustar.thinking.enumerated;

import static com.tustar.thinking.enumerated.Outcome.*;

/**
 * Created by tustar on 17-6-5.
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {

    PAPER(DRAW, LOST, WIN),
    SCISSORS(WIN, DRAW, LOST),
    ROCK(LOST, WIN, DRAW);

    private Outcome vPaper, vScissors, vRock;

    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPaper = paper;
        this.vScissors = scissors;
        this.vRock = rock;
    }

    @Override
    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPaper;
            case SCISSORS:
                return vScissors;
            case ROCK:
                return vRock;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
