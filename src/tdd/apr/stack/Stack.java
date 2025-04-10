package tdd.apr.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stack<T> {
    private final List<T> items = new ArrayList<>();

    public int size() {
        return items.size();
    }

    public void push(T item) {
        items.add(item);
    }

    public Optional<T> pop() {
        return (items.isEmpty())
                ? Optional.empty()
                : Optional.of(items.removeLast());
    }
}
