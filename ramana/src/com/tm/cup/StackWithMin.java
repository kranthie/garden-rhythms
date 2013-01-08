package com.tm.cup;

public class StackWithMin<T extends Comparable<T>> {
    LinkedList<T> regularItems = new LinkedList<T>();

    LinkedList<T> minValues = new LinkedList<T>();

    public T pop() {
        if (regularItems.head.data.equals(minValues.head.data))
            minValues.remove(minValues.head);
        return regularItems.remove(regularItems.head).data;
    }

    public void push(T data) {
        if (minValues.head == null || minValues.head.data.compareTo(data) >= 0)
            minValues.insert(data);
        regularItems.insert(data);
    }

    public T min() {
        return minValues.head.data;
    }

    public boolean isEmpty() {
        return regularItems.head == null;
    }

    public static void main(String[] args) {
        StackWithMin<Integer> swm = new StackWithMin<Integer>();
        swm.push(5);
        swm.push(7);
        swm.push(7);
        swm.push(3);
        swm.push(5);
        swm.push(8);
        while (!swm.isEmpty()) {
            System.out.println(swm.min());
            System.out.println(swm.pop());
        }
    }
}
