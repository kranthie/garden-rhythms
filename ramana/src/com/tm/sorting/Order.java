package com.tm.sorting;

import java.lang.reflect.Array;
import java.util.Comparator;

public class Order {
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

    public static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        System.arraycopy(mergeSort(array, 0, array.length - 1, comparator), 0, array, 0, array.length);
    }

    public static <T> T[] mergeSort(T[] array, int start, int end, Comparator<T> comparator) {
        if (start >= end) {
            T[] result = (T[]) Array.newInstance(array[0].getClass(), 1);
            result[0] = array[start];
            return result;
        }
        int mid = (start + end) / 2;
        return merge(mergeSort(array, start, mid, comparator), mergeSort(array, mid + 1, end, comparator), comparator);
    }

    public static <T> T[] merge(T[] a, T[] b, Comparator<T> comparator) {
        if (a.length == 0)
            return b;
        if (b.length == 0)
            return a;
        T[] result = (T[]) Array.newInstance(a[0].getClass(), a.length + b.length);
        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {
            if (comparator.compare(a[i], b[j]) > 0) {
                result[k++] = b[j++];
                if (j == b.length) {
                    System.arraycopy(a, i, result, k, a.length - i);
                    return result;
                }
            } else {
                result[k++] = a[i++];
                if (i == a.length) {
                    System.arraycopy(b, j, result, k, b.length - j);
                    return result;
                }
            }
        }
    }

    public static <T> void heapSort(T[] array, Comparator<T> comparator) {
        buildMinHeap(array, comparator);
        T[] result = (T[]) Array.newInstance(array[0].getClass(), array.length);
        int temp = array.length;
        for (int i = 0; i < array.length; i++) {
            result[i] = array[0];
            swap(array, 0, temp - 1);
            temp--;
            minHeapify(array, 0, comparator, temp);
        }
        System.arraycopy(result, 0, array, 0, array.length);
    }

    public static <T> void minHeapify(T[] array, int i, Comparator<T> comparator, int len) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < len && comparator.compare(array[i], array[l]) > 0)
            largest = l;
        if (r < len && comparator.compare(array[largest], array[r]) > 0)
            largest = r;
        if (i != largest) {
            swap(array, i, largest);
            minHeapify(array, largest, comparator, len);
        }
    }

    public static <T> void buildMinHeap(T[] array, Comparator<T> comparator) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            minHeapify(array, i, comparator, array.length);
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
