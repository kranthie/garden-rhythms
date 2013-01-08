package com.tm.cup;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T extends Comparable<T>> {
    static class Node<T> {
        Node<T> next;
        T data;
        
@Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node<T> other = (Node<T>) obj;
            if (data == null) {
                if (other.data != null)
                    return false;
            } else if (!data.equals(other.data))
                return false;
            if (next == null) {
                if (other.next != null)
                    return false;
            } else if (next != other.next)
                return false;
            return true;
        }

    }

    Node<T> head;

    public void insert(T data) {
        Node<T> n = new Node<T>();
        n.data = data;
        n.next = head;
        head = n;
    }

    public Node<T> remove(T data) {
        Node<T> y = null;
        Node<T> x = head;
        while (x != null) {
            if (data.equals(x.data)) {
                if (y != null)
                    y.next = x.next;
                else
                    head = x.next;
                break;
            }
            y = x;
            x = x.next;
        }
        return x;
    }

    public Node<T> remove(Node<T> x, Node<T> prev) {
        prev.next = x.next;
        return x;
    }

    public Node<T> remove(Node<T> x) {
        return remove(x.data);
    }

    public void removeDuplicates() {
        Node<T> x = head;
        while (x != null) {
            Node<T> z = x;
            Node<T> y = x.next;
            while (y != null) {
                if (x.data.equals(y.data)) {
                    remove(y, z);
                    y = y.next;
                    continue;
                }
                z = y;
                y = y.next;
            }
            x = x.next;
        }
    }

    public void removeDuplicatesWithBuffer() {
        Set<T> values = new HashSet<T>();
        Node<T> x = head;
        values.add(head.data);
        while (x.next != null) {
            Node<T> y = x.next;
            if (values.contains(y.data)) {
                remove(y, x);
                continue;
            }
            values.add(y.data);
            x = x.next;
        }
    }

    public Node<T> nthFromLast(int n) {
        if (head == null)
            return null;
        int index = 1;
        Node<T> x = head;
        while (x.next != null) {
            if (index == n)
                break;
            index++;
            x = x.next;
        }
        Node<T> y = head;
        x = x.next;
        while (x != null) {
            y = y.next;
            x = x.next;
        }

        return y;
    }

    public LinkedList<Integer> sum(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        int sum = 0;
        Node<Integer> x = l1.head;
        Node<Integer> y = l2.head;
        while (x != null && y != null) {
            sum += (x.data + y.data);
            result.insert(sum % 10);
            sum /= 10;
            x = x.next;
            y = y.next;
        }
        if (x == null)
            x = y;
        while (x != null) {
            sum += x.data;
            result.insert(sum % 10);
            sum /= 10;
            x = x.next;
        }
        if (sum != 0)
            result.insert(sum);
        result.reverse();
        return result;
    }

    public void reverse() {
        Node<T> y = null;
        Node<T> x = head;
        while (x != null) {
            Node<T> z = x;
            x = x.next;
            z.next = y;
            y = z;
        }
        head = y;
    }

    public Node<T> detectLoopBeginning() {
        Set<Node<T>> nodes = new HashSet<LinkedList.Node<T>>();
        Node<T> x = head;
        while (x != null) {
            if (!nodes.add(x))
                return x;
            x = x.next;
        }
        return null;
    }

    public void print() {
        Node<T> x = head;
        while (x != null) {
            System.out.println(x.data);
            x = x.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.insert(5);
        ll.insert(7);
        ll.insert(9);
        // System.out.println(ll.remove(7).data);
        ll.insert(7);
        ll.insert(9);
        ll.insert(11);
        ll.insert(13);
        // ll.removeDuplicatesWithBuffer();
        ll.removeDuplicates();
        ll.print();
        System.out.println(ll.nthFromLast(4).data);
        ll.remove(ll.head.next.next);
        ll.print();
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.insert(8);
        l1.insert(1);
        l1.insert(5);
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.insert(3);
        l2.insert(9);
        l2.insert(2);
        LinkedList<Integer> sum = ll.sum(l1, l2);
        sum.print();
        ll.insert(15);
        ll.head.next.next.next.next.next = ll.head.next.next;
        System.out.println(ll.detectLoopBeginning().data);
    }
}
