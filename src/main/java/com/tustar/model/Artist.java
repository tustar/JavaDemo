package com.tustar.model;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Tu on 7/24/15.
 */
public class Artist {
    private String name;
    private List<Member> members;
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<Member> getMembers() {
        return members.stream();
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getNationality() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", origin='" + origin + '\'' +
                '}';
    }
}
