package com.tustar.pattern.structural.proxy;

public class Client {
    public static void main(String[] args) {
        Searcher searcher = new ProxySearcher();
        searcher.doSearch("杨过", "玉女心经");
    }
}
