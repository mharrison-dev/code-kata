package tdd.apr.queue;

import java.util.Optional;

public class Queue<T> {
    private T entity = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public Optional<T> dequeue() {
        size = Math.max(0, size - 1);
        return (entity == null)
                ? Optional.empty()
                : Optional.of(entity);
    }

    public void enqueue(T entity) {
        this.entity = entity;
        size++;
    }
}
