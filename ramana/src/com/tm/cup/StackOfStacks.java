package com.tm.cup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfStacks<T> {
    int stackSize = 10;
    List<Stack<T>> stacks = new ArrayList<Stack<T>>();

    public T pop() {
        if (stacks.isEmpty())
            throw new RuntimeException("All substacks are empty");
        Stack<T> stack = stacks.get(stacks.size() - 1);
        T result = stack.remove(stack.size() - 1);
        if (stack.isEmpty())
            stacks.remove(stacks.size() - 1);
        return result;
    }

    public T pop(int i) {
        Stack<T> stack = stacks.get(i);
        T result = stack.remove(stack.size() - 1);
        if (stack.isEmpty())
            stacks.remove(stacks.size() - 1);
        return result;
    }

    public void push(T data) {
        Stack<T> stack = null;
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() >= stackSize) {
            stack = new Stack<T>();
            stacks.add(stack);
        } else
            stack = stacks.get(stacks.size() - 1);
        stack.push(data);
    }

    public static void main(String[] args) {
        StackOfStacks<Integer> sos = new StackOfStacks<Integer>();
        for (int i = 0; i < 91; i++)
            sos.push(i);
        System.out.println(sos.stacks.size());
        System.out.println(sos.pop());
        System.out.println(sos.stacks.size());
        System.out.println(sos.pop(3));
    }
}
