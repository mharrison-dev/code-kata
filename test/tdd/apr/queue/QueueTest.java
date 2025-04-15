package tdd.apr.queue;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void shouldReturnZero_forSize_whenQueueIsEmpty() {
        Queue<String> queue = new Queue<>();

        int expectedSize = 0;
        int actualSize = queue.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldReturnEmptyOptional_forDequeue_whenQueueIsEmpty() {
        Queue<String> queue = new Queue<>();

        Optional<String> expectedEntity = Optional.empty();
        Optional<String>actualEntity = queue.dequeue();
        assertEquals(expectedEntity, actualEntity);
    }
}