package com.tustar.lambada.chapter04;

import com.tustar.model.Artist;

import java.util.stream.Stream;

/**
 * Created by Tu on 7/24/15.
 */
public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();
}

