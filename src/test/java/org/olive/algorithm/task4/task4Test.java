package org.olive.algorithm.task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.olive.algorithm.task4.task4.getEdge;
import static org.olive.algorithm.task4.task4.put;

/**
 * task4Test.
 *
 * @author Elena Maltseva
 */
class task4Test {

    private static void assertEdgeListEquals(List<task4.Edge> expected, List<task4.Edge> actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                    testName + " — Ожидалось: " + expected + ", Получено: " + actual);
        } else {
            System.out.println(testName + " пройден. Результат: " + actual);
        }
    }

    @Test
    void testEmptyArray() {
        String[] names = {};
        task4.Node[][] nodesEmpty = new task4.Node[0][0];
        List<task4.Edge> expectedEmpty = new ArrayList<>();

        assertEdgeListEquals(expectedEmpty, getEdge(nodesEmpty.length, names, nodesEmpty), "Тест c пустой матрицей");
    }

    @Test
    void test() {
        String[] names = {"A","B","C"};
        task4.Node[][] nodes = new task4.Node[3][3];
        put(nodes, 0,1, new task4.Node(1500, 0)); // A-B
        put(nodes, 1,0, new task4.Node(1500,0)); // B-A
        put(nodes, 1,2, new task4.Node(2000,10)); // B-C
        put(nodes, 2,1, new task4.Node(2000,10)); // C-B

        List<task4.Edge> expected = List.of(
                new task4.Edge(names[0],names[1],new task4.Node(1500, 0)),
                new task4.Edge(names[1],names[0],new task4.Node(1500, 0)),
                new task4.Edge(names[1],names[2],new task4.Node(2000, 10)),
                new task4.Edge(names[2],names[1],new task4.Node(2000, 10))
        );

        assertEdgeListEquals(expected, getEdge(nodes.length, names, nodes), "Тест с 3 вершинами и 2 ребрами");
    }

}