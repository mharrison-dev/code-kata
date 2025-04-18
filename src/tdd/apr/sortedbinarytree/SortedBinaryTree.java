package tdd.apr.sortedbinarytree;

import java.util.ArrayList;
import java.util.List;

public class SortedBinaryTree<T> {
    private final List<T> valueList = new ArrayList<>();

    public SortedBinaryTree(T value) {
        valueList.add(value);
    }

    public void printValuesDuringPreOrderTraversal() {
        StringBuilder printStringBuilder = new StringBuilder();
        for (int i = 0; i < valueList.size(); i++) {
            printStringBuilder.append(valueList.get(i));
            if (i != valueList.size() - 1) {
                printStringBuilder.append(", ");
            }
        }

        System.out.print(printStringBuilder);
    }

    public void insert(T value) {
        valueList.add(value);
    }
}
