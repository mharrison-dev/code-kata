package tdd.apr.stack;

public class Stack<T> {
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(T item) {
        size++;
    }
}
