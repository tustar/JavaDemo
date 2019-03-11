package com.tustar.thinking.enumerated;

/**
 * Created by tustar on 17-6-5.
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
