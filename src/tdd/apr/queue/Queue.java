package tdd.apr.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Queue<T> {
    private final List<T> entityList = new ArrayList<>();

    public int size() {
        return entityList.size();
    }

    public Optional<T> dequeue() {
        return (entityList.isEmpty())
                ? Optional.empty()
                : Optional.of(entityList.removeFirst());
    }

    public void enqueue(T entity) {
        entityList.add(entity);
    }
}
