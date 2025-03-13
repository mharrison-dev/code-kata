package tdd.mar.karatechopii;

import org.junit.jupiter.api.Test;
import tdd.mar.karatechopi.KarateChopI;

import static org.junit.jupiter.api.Assertions.*;

class KarateChopIITest {
    @Test
    public void passGivenTest() {
        KarateChopII karateChop = new KarateChopII();

        assertEquals(-1, karateChop.chop(3, new int[0]));
        assertEquals(-1, karateChop.chop(3, new int[]{1}));
        assertEquals(0, karateChop.chop(1, new int[]{1}));

        assertEquals(0, karateChop.chop(1, new int[]{1, 3, 5}));
        assertEquals(1, karateChop.chop(3, new int[]{1, 3, 5}));
        assertEquals(2, karateChop.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, karateChop.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, karateChop.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, karateChop.chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, karateChop.chop(6, new int[]{1, 3, 5}));

        assertEquals(0, karateChop.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, karateChop.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, karateChop.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, karateChop.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, karateChop.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, karateChop.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, karateChop.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, karateChop.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, karateChop.chop(8, new int[]{1, 3, 5, 7}));
    }
}