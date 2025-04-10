package tdd.apr.stack;

import java.util.Optional;

public class Stack<T> {
    private T item = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(T item) {
        this.item = item;
        size++;
    }

    public Optional<T> pop() {
        return (item == null)
                ? Optional.empty()
                : Optional.of(item);
    }
}
