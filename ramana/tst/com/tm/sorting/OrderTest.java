package com.tm.sorting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public void testSelectionSort() {
        setUp();
        Order.selectionSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testInsertionSort() {
        setUp();
        Order.insertionSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testMergeSort() {
        setUp();
        Order.mergeSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testHeapSort() {
        setUp();
        Order.heapSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testQuickSort() {
        setUp();
        Order.quickSort(b, intComparator);
        for (int i = 0; i < b.length; i++)
            assertEquals(b[i].intValue(), i + 1);
    }

    @Test
    public void testMergeMultipleSortedArrays() {
        List<Integer[]> arrays = new ArrayList<Integer[]>();
        arrays.add(new Integer[] { 1, 6, 9, 23 });
        arrays.add(new Integer[] { 2, 16, 19, 24, 25 });
        arrays.add(new Integer[] { 4, 5, 12, 21, 22 });
        arrays.add(new Integer[] { 3, 7, 11, 17, 18 });
        arrays.add(new Integer[] { 8, 10, 13, 14, 15, 20 });
        Integer[] a = Order.mergeMultipleSortedArrays(arrays, intComparator);
        for (int i = 0; i < a.length; i++)
            assertEquals(a[i].intValue(), i + 1);
    }

}
