package org.olive.algorithm.task6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.olive.algorithm.task6.Task6_2.topologicalSortDFS;

/**
 * Task6_2Test.
 *
 * @author Elena Maltseva
 */
class Task6_2Test {

    @Test
    void test1() {
        // Граф: 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        int[][] adj1 = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        List<Integer> result1 = topologicalSortDFS(adj1);
        System.out.println("Тест 1: " + result1);
        assertFalse(result1.isEmpty());
        assertEquals(4, result1.size());
    }

    @Test
    void test2() {
        int[][] adj2 = {{0}};
        List<Integer> result2 = topologicalSortDFS(adj2);
        System.out.println("Тест 2 : " + result2);
        assertEquals(result2, List.of(0));
    }

    @Test
    void test3() {
        int[][] adj3 = {};
        List<Integer> result3 = topologicalSortDFS(adj3);
        System.out.println("Тест 3: " + result3);
        assertEquals(result3, List.of());
    }

    @Test
    void test4() {
        // Граф: 0 -> 1, 1 -> 2, 2 -> 0 (цикл)
        int[][] adj4 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        List<Integer> result4 = topologicalSortDFS(adj4);
        System.out.println("Тест 4: " + result4);
        assertTrue(result4.isEmpty());
    }
}