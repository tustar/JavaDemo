package com.tustar.pattern.behavioral.interpreter;

public class NonterminalExpression extends AbstractExpression {

    private AbstractExpression left;
    private AbstractExpression right;

    public NonterminalExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void interpret(Context context) {

    }
}
