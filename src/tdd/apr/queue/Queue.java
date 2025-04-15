package tdd.apr.queue;

import java.util.Optional;

public class Queue<T> {
    private T entity = null;

    public int size() {
        return 0;
    }

    public Optional<T> dequeue() {
        return (entity == null)
                ? Optional.empty()
                : Optional.of(entity);
    }

    public void enqueue(T entity) {
        this.entity = entity;
    }
}
