package com.tustar.java7.chapter02;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tustar on 7/29/15.
 */
public class Listing_2_1 {

    public static void main(String[] args) {
        Path listing = Paths.get("/usr/bin/zip");
        System.out.println("File Name [" + listing.getFileName() + "]");
        System.out.println("Number of Name Elements in the Path [" + listing.getFileName() + "]");
        System.out.println("Parent Path [" + listing.getParent() + "]");
        System.out.println("Root of Path [" + listing.getRoot() + "]");
        System.out.println("Subpath from root, 2 element deep [" + listing.subpath(0, 2) + "]");
    }
}
