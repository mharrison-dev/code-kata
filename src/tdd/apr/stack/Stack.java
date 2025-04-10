package tdd.apr.stack;

import java.util.Optional;

public class Stack<T> {
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(T item) {
        size++;
    }

    public Optional<T> pop() {
        return Optional.empty();
    }
}
