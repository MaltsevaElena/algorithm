package org.olive.algorithm.task3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * QuickSortTest.
 *
 * @author Elena Maltseva
 */

class QuickSortTest {

    private void testSorting(int[] input, int[] expected) {
        int[] actual = Arrays.copyOf(input, input.length);
        QuickSort.quickSort(actual, 0, actual.length - 1);
        assertArrayEquals(expected, actual, "Массив отсортирован некорректно.");
    }

    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        testSorting(input, expected);
    }

    @Test
    void testSingleElementArray() {
        int[] input = {5};
        int[] expected = {5};
        testSorting(input, expected);
    }

    @Test
    void testReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        testSorting(input, expected);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 6, 9};
        testSorting(input, expected);
    }

    @Test
    void testArrayWithNegatives() {
        int[] input = {0, -5, 10, -2, 7, 3};
        int[] expected = {-5, -2, 0, 3, 7, 10};
        testSorting(input, expected);
    }

}