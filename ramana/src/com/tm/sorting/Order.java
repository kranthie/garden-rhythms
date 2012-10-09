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
        buildMaxHeap(array, comparator);
        int hithertoUnsortedArrayLength = array.length;
        for (int i = 0; i < array.length; i++) {
            hithertoUnsortedArrayLength--;
            swap(array, 0, hithertoUnsortedArrayLength);
            maxHeapify(array, 0, comparator, hithertoUnsortedArrayLength);
        }
    }

    public static <T> void maxHeapify(T[] array, int i, Comparator<T> comparator, int len) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < len && comparator.compare(array[i], array[l]) < 0)
            smallest = l;
        if (r < len && comparator.compare(array[smallest], array[r]) < 0)
            smallest = r;
        if (i != smallest) {
            swap(array, i, smallest);
            maxHeapify(array, smallest, comparator, len);
        }
    }

    public static <T> void buildMaxHeap(T[] array, Comparator<T> comparator) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            maxHeapify(array, i, comparator, array.length);
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    public static <T> void quickSort(T[] array, Comparator<T> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    public static <T> void quickSort(T[] array, int start, int end, Comparator<T> comparator) {
        if (start >= end)
            return;
        int p = partition(array, start, end, comparator);
        quickSort(array, start, p - 1, comparator);
        quickSort(array, p + 1, end, comparator);
    }

    public static <T> int partition(T[] array, int start, int end, Comparator<T> comparator) {
        int p = start - 1;
        for (int i = start; i < end; i++) {
            if (comparator.compare(array[i], array[end]) < 0) {
                p++;
                swap(array, p, i);
            }
        }
        p++;
        swap(array, p, end);
        return p;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
