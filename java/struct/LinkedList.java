package day02;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private class Node {
        T data = null;
        Node next = null;

        Node() {}

        Node(T data) {
            this.data = data;
        }
    }

    private Node header = new Node();
    private Node tail = header;

    private int size = 0;

    public int size() {
        return size;
    }

    public T head() {
        return header.next != null ? header.next.data : null;
    }

    public T tail() {
        return tail.data;
    }

    public LinkedList() {}

    public LinkedList<T> add(T data) {
        tail.next = new Node(data);
        tail = tail.next;
        size++;
        return this;
    }

    public boolean remove(T target) {
        var tmp = header;
        var prev = header;
        while (tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
            if (target.equals(tmp.data)) {
                prev.next = tmp.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public T getAt(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("index: " + index + " out of size: " + size);
        var tmp = header;
        while (index-- >= 0) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void setAt(int index, T data) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("index: " + index + " out of size: " + size);
        var tmp = header;
        while (index-- >= 0) {
            tmp = tmp.next;
        }
        tmp.data = data;
    }

    public T find(T data) {
        Node ptr = header;
        while (ptr.next != null) {
            ptr = ptr.next;
            if (data.equals(ptr.data)) {
                return ptr.data;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (size <= 0) return "[ ]";
        var tmp = header;
        StringBuilder sb = new StringBuilder("[ ");
        while (tmp.next != null) {
            tmp = tmp.next;
            sb.append(tmp.data).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), " ]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        Node cursor = header;

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public T next() {
            cursor = cursor.next;
            return cursor.data;
        }
    }
}
