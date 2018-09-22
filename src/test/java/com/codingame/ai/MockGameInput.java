package com.codingame.ai;

import java.util.LinkedList;
import java.util.Queue;

public class MockGameInput implements Player.GameInput {

    public Queue returnValues;

    public MockGameInput() {
        returnValues = new LinkedList();
    }

    @SuppressWarnings("unchecked")
    public void addAllToGameInput(Queue values) {
        returnValues.addAll(values);
    }

    @SuppressWarnings("unchecked")
    public void addToGameInput(Object obj) {
        returnValues.add(obj);
    }

    @Override
    public int nextInt() {
        return (int) returnValues.remove();
    }

    @Override
    public String nextLine() {
        return (String) returnValues.remove();
    }

    @Override
    public String next() {
        return (String) returnValues.remove();
    }

    @Override
    public boolean hasNextLine() {
        return false;
    }
}
