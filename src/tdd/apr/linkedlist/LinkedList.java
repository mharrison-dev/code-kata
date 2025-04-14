package tdd.apr.linkedlist;

import java.util.Optional;

public class LinkedList<T> {
    private T value = null;

    public Optional<T> value() {
        return (value== null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public Optional<T> next() {
        return Optional.empty();
    }

    public void setValue(T value) {
        this.value = value;
    }
}
