package tdd.apr.linkedlist;

import java.util.Optional;

public class LinkedList<T> {
    private T value = null;
    private LinkedList<T> next = null;

    public Optional<T> value() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public Optional<LinkedList<T>> next() {
        return (next == null)
                ? Optional.empty()
                : Optional.of(next);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }
}
