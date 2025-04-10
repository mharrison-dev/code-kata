package tdd.apr.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stack<T> {
    private int size = 0;
    private List<T> items = new ArrayList<>();

    public int size() {
        return size;
    }

    public void push(T item) {
        items.add(item);
        size++;
    }

    public Optional<T> pop() {
        return (items.isEmpty())
                ? Optional.empty()
                : Optional.of(items.removeLast());
    }
}
