package tdd.apr.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<String> queue = null;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void shouldReturnZero_forSize_whenQueueIsEmpty() {
        int expectedSize = 0;
        int actualSize = queue.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldReturnEmptyOptional_forDequeue_whenQueueIsEmpty() {
        Optional<String> expectedEntity = Optional.empty();
        Optional<String> actualEntity = queue.dequeue();
        assertEquals(expectedEntity, actualEntity);
    }

    @Test
    void shouldAddEntity_withEnqueue_whenQueueIsEmpty() {
        String entity = "foo";

        queue.enqueue(entity);

        Optional<String> expectedEntity = Optional.of(entity);
        Optional<String> actualEntity = queue.dequeue();
        assertEquals(expectedEntity, actualEntity);
    }

    @Test
    void shouldReturnOne_forSize_afterEntityIsEnqueued() {
        String entity = "foo";

        queue.enqueue(entity);

        int expectedSize = 1;
        int actualSize = queue.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldReturnZero_forSize_afterEntityIsEnqueuedAndDequeued() {
        String entity = "foo";

        queue.enqueue(entity);
        queue.dequeue();

        int expectedSize = 0;
        int actualSize = queue.size();
        assertEquals(expectedSize, actualSize);
    }
}