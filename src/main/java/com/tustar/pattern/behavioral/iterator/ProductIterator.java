package com.tustar.pattern.behavioral.iterator;

import java.util.List;

public class ProductIterator implements AbstractIterator {

    private List products;
    private int start;
    private int end;

    public ProductIterator(ProductList list) {
        this.products = list.getObjects();
        start = 0;
        end = products.size() - 1;
    }


    @Override
    public void next() {
        if (start < products.size()) {
            start++;
        }
    }

    @Override
    public boolean isLast() {
        return start == products.size();
    }

    @Override
    public void previous() {
        if (end > -1) {
            end--;
        }
    }

    @Override
    public boolean isFirst() {
        return end == -1;
    }

    @Override
    public Object getNextItem() {
        return products.get(start);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(end);
    }
}
