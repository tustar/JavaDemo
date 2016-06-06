package com.tustar.lambada.chapter03;

import com.tustar.model.Artist;

import java.util.List;

/**
 * Created by Tu on 7/24/15.
 */
public class Question2 {

    public static int countBandMembersInternal(List<Artist> artists) {
//        return artists.stream()
//                .map(artist -> artist.getMembers().count())
//                .reduce(0L, Long::sum)
//                .intValue();
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, (acc, x) -> acc + x)
                .intValue();
    }
}
