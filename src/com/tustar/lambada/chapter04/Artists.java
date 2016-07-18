package com.tustar.lambada.chapter04;

import com.tustar.model.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Created by Tu on 7/24/15.
 */
public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
//            Optional<Artist>.empty();
        }

        return Optional.of(artists.get(index));
    }

//    public Optional<String> getArtistName(int index) {
//        Optional<Artist> artist = getArtist(indexd);
//        return artist.map(Artist::getName)
//                .orElse("unknow");
//    }
}
