package day02;

// 自定义，数组队列

// 栈与队的实现均可以使用数组或者链表来做，这里只使用数组来实现

import java.util.Iterator;

class Queue<T> implements Iterable<T> {
    private int size = 0;
    private int capacity = 8;
    private Object[] arr = new Object[capacity];

    private int head = 0;
    private int tail = 0;

    public int size() {
        return size;
    }

    public Queue() {}

    Queue(int size) {
        this.size = size;
        expand();
    }

    private void expand() {
        int newCap = capacity;
        while (size >= newCap)
            newCap = (int) (newCap * 1.7);
        var tmp = new Object[newCap];
        int cursor = 0;
        int beg = head;
        while (beg % capacity != tail % capacity) {
            tmp[cursor++] = arr[beg++ % capacity];
        }
        arr = tmp;
        head = 0;
        tail = size - 1;
        capacity = newCap;
    }

    public Queue<T> push(T data) {
        if (++size >= capacity) expand();
        arr[tail++ % capacity] = data;
        return this;
    }

    public T pop() {
        if (size <= 0) throw new ArrayIndexOutOfBoundsException("queue has no element now");
        size--;
        return (T) arr[head++ % capacity];
    }

    public T getAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index + " out of size: " + size);
        return (T) arr[(index + head) % capacity];
    }

    public void setAt(int index, T val) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index + " out of size: " + size);
        arr[(index + head) % capacity] = val;
    }

    @Override
    public String toString() {
        if (size <= 0) return "[ ]";
        StringBuilder sb = new StringBuilder("<- ");
        for (var i : this) {
            sb.append(i).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), " <-");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        int cursor = head;
        int n = 0;

        @Override
        public boolean hasNext() {
            return n < size;
        }

        @Override

        public T next() {
            n++;
            return (T) arr[cursor++ % capacity];
        }
    }
}
