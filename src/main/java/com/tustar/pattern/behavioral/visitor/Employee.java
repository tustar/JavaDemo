package com.tustar.pattern.behavioral.visitor;

public interface Employee {
    void accept(Department handler);
}
