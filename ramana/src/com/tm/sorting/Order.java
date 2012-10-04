package com.tm.sorting;

import java.util.Comparator;

public class Order {
    private static Comparator<Integer> intComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < array.length; i++) {
                if (comparator.compare(array[i - 1], array[i]) > 0) {
                    swap(array, i - 1, i);
                    sorted = false;
                }
            }
        }
    }

    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++)
                if (comparator.compare(array[minIndex], array[j]) > 0)
                    minIndex = j;
            swap(array, i, minIndex);
        }
    }

    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; i++) {
            int sortedUpTo = i - 1;
            if (comparator.compare(array[sortedUpTo], array[i]) > 0) {
                for (int j = sortedUpTo; j >= 0; j--) {
                    if (comparator.compare(array[j], array[j + 1]) > 0)
                        swap(array, j + 1, j);
                    else
                        break;
                }
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 3, 7, 2, 1, 9, 4, 5, 10, 8, 6 };
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = new Integer(a[i]);
        // bubbleSort(b, intComparator);
        // selectionSort(b, intComparator);
        insertionSort(b, intComparator);
        for (Integer i : b)
            System.out.println(i);
    }
}
