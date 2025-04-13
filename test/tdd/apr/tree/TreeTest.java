package tdd.apr.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree<String> tree = null;

    @BeforeEach
    void setUp() {
        tree = new Tree<>();
    }

    @Test
    void shouldInstantiateTree() {
        assertDoesNotThrow(() -> {
            tree = new Tree();
        }, "Instantiation of a tree should not throw an exception");
    }

    @Test
    void shouldGetEmptyOptional_forChildren_whenTreeIsEmpty() {
        Optional<List<Tree<String>>> expectedChildren = Optional.empty();
        Optional<List<Tree<String>>> actualChildren = tree.children();
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void shouldGetZero_forDepthOfRoot_whenTreeIsEmpty() {
        int expectedDepth = 0;
        int actualDepth = tree.depth();
        assertEquals(expectedDepth, actualDepth);
    }

    @Test
    void shouldGetZero_forHeightOfRoot_whenTreeIsEmpty() {
        int expectedHeight = 0;
        int actualHeight = tree.height();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void shouldInstantiateTree_forStrings() {
        assertDoesNotThrow(() -> {
            tree = new Tree<String>();
        }, "Instantiation of a tree for strings should not throw an exception");
    }

    @Test
    void shouldGetEmptyOptional_forValue_whenValueHasNotBeenSet() {
        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = tree.getValue();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldGetValue_whenValueHasBeenSet() {
        String value = "foo";

        tree.setValue(value);

        Optional<String> expectedValue = Optional.of(value);
        Optional<String> actualValue = tree.getValue();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldAddChild_withItsValue() {
        String valueOfChild = "foo";

        tree.addChild(valueOfChild);

        List<Tree<String>> expectedChildren = getOptionalOfChild(valueOfChild);
        List<Tree<String>> actualChildren = tree.children().get();
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void shouldAddChild_withoutItsValue() {
        tree.addChild();

        List<Tree<String>> expectedChildren = getOptionalOfChild(new String[]{null});
        List<Tree<String>> actualChildren = tree.children().get();
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void shouldAddTwoChildren() {
        String valueOfChild = "foo1";
        String otherValueOfChild = "foo2";

        tree.addChild(valueOfChild);
        tree.addChild(otherValueOfChild);

        List<Tree<String>> expectedChildren = getOptionalOfChild(valueOfChild, otherValueOfChild);
        List<Tree<String>> actualChildren = tree.children().get();
        assertEquals(expectedChildren, actualChildren);
    }

    private List<Tree<String>> getOptionalOfChild(String... valuesOfChildren) {
        List<Tree<String>> children = new ArrayList<>();
        for (String valueOfChild : valuesOfChildren) {
            Tree<String> child = new Tree<>();
            if (valueOfChild != null) {
                child.setValue(valueOfChild);
            }

            children.add(child);
        }

        return children;
    }

    @Test
    void shouldGetOne_forHeightOfRoot_whenRootOnlyHasLeafNodes() {
        tree.addChild();

        int expectedHeight = 1;
        int actualHeight = tree.height();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void shouldGetTwo_forHeightOfRoot_whenRootHasAtLeastOneChildWithLeafNode() {
        tree.addChild();
        tree.children().get()
                .getFirst()
                .addChild();

        int expectedHeight = 2;
        int actualHeight = tree.height();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void shouldGetTwo_forHeightOfRoot_whenRootHasAtLeastOneChildOnOffBranchWithLeafNodes() {
        tree.addChild();
        tree.addChild();
        tree.children().get()
                .getLast()
                .addChild();

        int expectedHeight = 2;
        int actualHeight = tree.height();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void shouldGetOne_forDepthOfNode_whenItIsChildOfRoot() {
        tree.addChild();
        Tree<String> child = tree.children().get().getFirst();

        int expectedDepth = 1;
        int actualDepth = child.depth();
        assertEquals(expectedDepth, actualDepth);
    }
}