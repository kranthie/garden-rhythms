package com.tm.sorting;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class OrderTest {
    private static Comparator<Integer> intComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    private Integer[] b;

    protected void setUp() {
        int[] a = { 3, 7, 2, 1, 9, 4, 5, 10, 8, 6 };
        b = new Integer[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = new Integer(a[i]);
    }

    @Test
    public void testBubbleSort() {
        setUp();
        Order.bubbleSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testselectionSort() {
        setUp();
        Order.selectionSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testinsertionSort() {
        setUp();
        Order.insertionSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testmergeSort() {
        setUp();
        Order.mergeSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }
}
