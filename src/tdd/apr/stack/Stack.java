package tdd.apr.stack;

public class Stack {
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(Integer item) {
        size++;
    }
}
