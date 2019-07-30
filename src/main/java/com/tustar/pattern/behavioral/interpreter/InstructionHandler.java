package com.tustar.pattern.behavioral.interpreter;

import java.util.Stack;

public class InstructionHandler {

    private AbstractNode node;

    public void handle(String instruction) {
        AbstractNode left = null;
        AbstractNode right = null;
        DirectionNode direction = null;
        ActionNode action = null;
        DistanceNode distance = null;
        Stack<AbstractNode> stack = new Stack<>();
        String[] words = instruction.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase("and")) {
                left = stack.pop();
                String word1 = words[++i];
                direction = new DirectionNode(word1);
                String word2 = words[++i];
                action = new ActionNode(word2);
                String word3 = words[++i];
                distance = new DistanceNode(word3);
                right = new SentenceNode(direction, action, distance);
                stack.push(new AndNode(left, right));
            } else {
                String word1 = words[i];
                direction = new DirectionNode(word1);
                String word2 = words[++i];
                action = new ActionNode(word2);
                String word3 = words[++i];
                distance = new DistanceNode(word3);
                left = new SentenceNode(direction, action, distance);
                stack.push(left);
            }
        }
        node = stack.pop();
    }

    public String output() {
        String result = node.interpret();
        return result;
    }
}
