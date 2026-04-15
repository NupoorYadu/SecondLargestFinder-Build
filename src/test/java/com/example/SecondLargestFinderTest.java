package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondLargestFinderTest {

    @Test
    public void testNormalArray() {
        int[] arr = { 12, 35, 1, 10, 34, 1, 45, 23 };
        assertEquals(35, SecondLargestFinder.findSecondLargest(arr));
    }

    @Test
    public void testSimpleArray() {
        int[] arr = { 1, 2 };
        assertEquals(1, SecondLargestFinder.findSecondLargest(arr));
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = { 5, 5, 3, 2, 1 };
        assertEquals(3, SecondLargestFinder.findSecondLargest(arr));
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = { -5, -10, -1, -20 };
        assertEquals(-5, SecondLargestFinder.findSecondLargest(arr));
    }

    @Test
    public void testMixedNumbers() {
        int[] arr = { 100, -50, 75, 25, 90 };
        assertEquals(90, SecondLargestFinder.findSecondLargest(arr));
    }

    @Test
    public void testNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargestFinder.findSecondLargest(null));
    }

    @Test
    public void testSingleElement() {
        int[] arr = { 5 };
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargestFinder.findSecondLargest(arr));
    }

    @Test
    public void testIdenticalElements() {
        int[] arr = { 5, 5, 5, 5 };
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargestFinder.findSecondLargest(arr));
    }
}
