package day02;

import java.util.Iterator;

// 自定义，链栈

// 栈与队的实现均可以使用数组或者链表来做，这里只使用较为简单的链表来实现
public class Stack<T extends Comparable<T>> implements Iterable<T> {

    class Node {
        T data = null;
        Node next = null;

        Node() {}

        Node(T data) {
            this.data = data;
        }
    }

    private Node header = new Node();

    private int size = 0;

    public int size() {
        return size;
    }

    public T top() {
        return header.next != null ? header.next.data : null;
    }

    public Stack<T> push(T data) {
        var tmp = new Node(data);
        tmp.next = header.next;
        header.next = tmp;
        size++;
        return this;
    }

    public T pop() {
        if (size <= 0) return null;
        var tmp = header.next;
        header.next = tmp.next;
        size--;
        return tmp.data;
    }

    @Override
    public String toString() {
        if (size <= 0) return "[ ]";
        StringBuilder sb = new StringBuilder("-> ");
        var tmp = header;
        while (tmp.next != null) {
            tmp = tmp.next;
            sb.append(tmp.data).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), " )");
        return sb.toString();
    }

    @Override
    public MyIterator iterator() {
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
