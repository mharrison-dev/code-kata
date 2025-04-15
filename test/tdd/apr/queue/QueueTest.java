package tdd.apr.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void shouldReturnZero_forSize_whenQueueIsEmpty() {
        Queue queue = new Queue();

        int expectedSize = 0;
        int actualSize = queue.size();
        assertEquals(expectedSize, actualSize);
    }
}