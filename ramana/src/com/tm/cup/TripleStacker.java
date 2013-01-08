package com.tm.cup;

public class TripleStacker<T> {
    static class Node<T> {
        T data;
        int current = -1;
        int next = -1;
    }

    Node[] nodes = new Node[3];

    Node[] tops = new Node[3];

    int index = 0;

    Node<T> pop(int i) {
        if (tops[i] == null)
            throw new RuntimeException("Stack is empty");
        Node<T> result = tops[i];
        if (result.next != -1)
            tops[i] = nodes[result.next];
        else
            tops[i] = null;
        nodes[result.current] = null;
        return result;
    }

    public void push(T data, int i) {
        if (index >= nodes.length)
            upsizeCapacity();
        Node<T> temp = tops[i];
        tops[i] = new Node();
        tops[i].data = data;
        tops[i].current = index;
        if (temp != null)
            tops[i].next = temp.current;
        nodes[index++] = tops[i];
    }
    
    public boolean isEmpty(int i) {
        return tops[i] == null;
    }
    
    public Node<T> top(int i) {
        return tops[i];
    }

    private void upsizeCapacity() {
        int capacity = nodes.length * 2;
        Node[] temp = new Node[capacity];
        index = 0;
        for (int i = 0; i < tops.length; i++) {
            Node<T> n = tops[i];
            while (n != null) {
                temp[index++] = n;
                if (n.next != -1)
                    n = nodes[n.next];
                else
                    n = null;
            }
        }
        nodes = temp;
    }

    public static void main(String[] args) {
        TripleStacker<Integer> saq = new TripleStacker<Integer>();
        for (int i = 0; i < 5; i++)
            saq.push(i, i % 3);
        System.out.println(saq.pop(1).data);
        System.out.println(saq.pop(1).data);
        System.out.println(saq.pop(2).data);
    }
}
