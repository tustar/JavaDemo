package com.tustar.thinking.enumerated;

import static com.tustar.thinking.enumerated.Outcome.*;

/**
 * Created by tustar on 17-6-5.
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };

    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this) ? DRAW
                : ((opponent == loser) ? WIN : LOST));
    }


    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
