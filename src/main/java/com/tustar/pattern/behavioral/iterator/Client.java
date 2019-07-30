package com.tustar.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List products = new ArrayList();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("四十二章经");

        AbstractObjectList list = new ProductList(products);
        AbstractIterator iterator = list.createIterator();

        System.out.println("正向遍历");
        while (!iterator.isLast()) {
            System.out.print(iterator.getNextItem() + "=>");
            iterator.next();
        }
        System.out.println();
        System.out.println("-----------------");
        System.out.println("逆向遍历");
        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem() + "=>");
            iterator.previous();
        }
    }
}
