package com.tustar.thinking.enumerated;

import static com.tustar.thinking.enumerated.Outcome.*;

/**
 * Created by tustar on 17-6-5.
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return DRAW;
                case SCISSORS: return LOST;
                case ROCK: return WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return WIN;
                case SCISSORS: return DRAW;
                case ROCK: return LOST;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return LOST;
                case SCISSORS: return WIN;
                case ROCK: return DRAW;
            }
        }
    };

    public abstract Outcome compete(RoShamBo3 competitor);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
