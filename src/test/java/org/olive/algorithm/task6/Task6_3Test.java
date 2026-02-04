package org.olive.algorithm.task6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.olive.algorithm.task6.Task6_3.lcsLenghtAndString;

/**
 * Task6_3Test.
 *
 * @author Elena Maltseva
 */
class Task6_3Test {
    private final static String ZERO_LENGHT_AND_EMPTY_STRING = "0 ";

    @Test
    void testEmpty() {
        String a = "";
        String b = "";
        String result = lcsLenghtAndString(a, b);
        assertEquals(ZERO_LENGHT_AND_EMPTY_STRING, result);
    }

    @Test
    void testEmpty2() {
        String a = "ABC";
        String b = "";
        String result = lcsLenghtAndString(a, b);
        assertEquals(ZERO_LENGHT_AND_EMPTY_STRING, result);
    }

    @Test
    void testEqualsString() {
        String a = "HELLO";
        String b = "HELLO";
        String result = lcsLenghtAndString(a, b);
        assertEquals("5 HELLO", result);
    }

    @Test
    void test4() {
        String a = "ABC";
        String b = "def";
        String result = lcsLenghtAndString(a, b);
        assertEquals(ZERO_LENGHT_AND_EMPTY_STRING, result);
    }

    @Test
    void test5() {
        String a = "ABCBDAB";
        String b = "BDCABA";
        String result = lcsLenghtAndString(a, b);
        List<String> expectedResult = List.of("4 BCDA", "4 BCBA");
        assertTrue(expectedResult.contains(result));
    }

    @Test
    void test6() {
        String a = "AAAA";
        String b = "AA";
        String result = lcsLenghtAndString(a, b);
        assertEquals("2 AA", result);
    }

}