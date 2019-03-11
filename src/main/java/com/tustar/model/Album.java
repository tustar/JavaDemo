package com.tustar.model;

import java.util.List;

/**
 * Created by Tu on 7/24/15.
 */
public class Album {
    private String name;
    private List<Track> trackList;
    private List<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", trackList=" + trackList +
                ", musicians=" + musicians +
                '}';
    }
}
