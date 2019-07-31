package com.tustar.pattern.behavioral.visitor;

public abstract class Department {

    public abstract void visit(FullTimeEmployee employee);

    public abstract void visit(PartTimeEmployee employee);
}
