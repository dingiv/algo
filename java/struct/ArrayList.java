package day02;

import java.util.Iterator;

class ArrayList<T> implements Iterable<T> {

  private Object[] arr;
  private int capacity = 8;
  private int size = 0;

  public int size() {
    return size;
  }

  ArrayList() {
    arr = new Object[capacity];
  }

  ArrayList(int size) {
    while (capacity < size) capacity *= 2;
    this.size = size;
    arr = new Object[capacity];
  }

  private void expand(int newSize) {
    while (newSize > capacity) capacity *= 2;
    var tmp = new Object[capacity];
    for (int i = 0; i < size; ++i) {
      tmp[i] = arr[i];
    }
    arr = tmp;
  }

  public ArrayList<T> add(T val) {
    if (size >= capacity) expand(size + 1);
    arr[size++] = val;
    return this;
  }

  public T removeAt(int id) {
    if (id < 0 || id > size) return null;
    var tmp = arr[id];
    for (int i = id; i < size - 1; ++i) {
      arr[i] = arr[i + 1];
    }
    size--;
    return (T) tmp;
  }

  public void setAt(int id, T val) {
    if (id >= size || id < 0) throw new ArrayIndexOutOfBoundsException(
      "Index " + id + " out of bounds for length " + size
    );
    arr[id] = val;
  }

  public T getAt(int id) {
    if (id >= size || id < 0) throw new ArrayIndexOutOfBoundsException(
      "Index " + id + " out of bounds for length " + size
    );
    return (T) arr[id];
  }

  @Override
  public String toString() {
    if (size <= 0) return "[ ]";
    StringBuilder sb = new StringBuilder("[ ");
    for (int i = 0; i < size - 1; ++i) {
      sb.append(arr[i]).append(", ");
    }
    sb.append(arr[size - 1]).append(" ]");
    return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T> {

    int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < size;
    }

    @Override
    public T next() {
      return (T) arr[cursor++];
    }
  }
}
