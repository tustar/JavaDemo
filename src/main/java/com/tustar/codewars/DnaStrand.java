package com.tustar.codewars;

/**
 * Created by tustar on 7/26/15.
 */
public class DnaStrand {
//    public static String makeComplement(String dna) {
//        return dna.chars()
//                .mapToObj(ch -> {
//                    String newCh = "";
//                    switch (ch) {
//                        case 'A':
//                            newCh = "T";
//                            break;
//                        case 'T':
//                            newCh = "A";
//                            break;
//                        case 'C':
//                            newCh = "G";
//                            break;
//                        case 'G':
//                            newCh = "C";
//                            break;
//                    }
//                    return newCh;
//                })
//                .collect(Collectors.joining(""));
//    }

    public static String makeComplement(String dna) {
        return dna
                .replaceAll("A", "Z")
                .replaceAll("T", "A")
                .replaceAll("Z", "T")
                .replaceAll("C", "Z")
                .replaceAll("G", "C")
                .replaceAll("Z", "G");
    }
}
