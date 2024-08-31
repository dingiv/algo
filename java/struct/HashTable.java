package day02;

import java.util.Iterator;

public class HashTable<K extends Comparable<K>, V> implements Iterable<HashTable<K, V>.Entry> {

  private int size = 0;

  public int size() {
    return size;
  }

  private static int M = 8;
  private static int RESIZE_THRESHOLD = 8;

  private ArrayList<LinkedList<Entry>> arr = new ArrayList<LinkedList<Entry>>();

  private int getHashCode(K key) {
    return (key.hashCode() * 31) % M;
  }

  public HashTable() {
    for (int i = 0; i < M; i++) {
      arr.add(new LinkedList<>());
    }
  }

  public class Entry {

    K key = null;
    V val = null;
    int hashCode = 0;

    public Entry() {}

    public Entry(K key, V val) {
      this.key = key;
      this.val = val;
      this.hashCode = getHashCode(key);
    }

    @Override
    public int hashCode() {
      return this.key.hashCode();
    }

    @Override
    public boolean equals(Object object) {
      return this.key.hashCode() == ((Entry) object).key.hashCode();
    }

    @Override
    public String toString() {
      return "{code:" + hashCode + ",k:" + key + ",v:" + val + "}";
    }
  }

  private void resize(int newLength) throws Exception {
    if (newLength < 0) newLength = size * 2;
    if (newLength < M) {
      throw new Exception("new size must larger than M: " + M);
    }
    M = newLength;
    ArrayList<LinkedList<Entry>> newArr = new ArrayList<>(M);
    for (int i = 0; i < newArr.size(); ++i) {
      newArr.setAt(i, new LinkedList<>());
    }
    for (var list : arr) {
      if (list.size() > 0) {
        var e = list.getAt(0);
        e.hashCode = getHashCode(e.key);
        for (var entry : list) {
          entry.hashCode = e.hashCode;
        }
        newArr.setAt(e.hashCode, list);
      }
    }
    arr = newArr;
  }

  public void set(K key, V val) throws Exception {
    var newOne = new Entry(key, val);
    System.out.println(key);

    LinkedList<Entry> le = arr.getAt(newOne.hashCode);
    var target = le.find(newOne);
    if (target != null) {
      target.val = val;
    } else {
      le.add(newOne);
      size++;
      if (le.size() >= RESIZE_THRESHOLD) {
        resize(M * 2);
      }
    }
  }

  public V get(K key) {
    V tmp = null;
    for (var i : arr.getAt(getHashCode(key))) {
      if (i.key == key) {
        tmp = i.val;
        break;
      }
    }
    return tmp;
  }

  public V delete(K key) {
    V tmp = null;
    var ll = arr.getAt(getHashCode(key));
    for (var i : ll) {
      if (i.key == key) {
        tmp = i.val;
        ll.remove(i);
        break;
      }
    }
    return tmp;
  }

  @Override
  public Iterator<HashTable<K, V>.Entry> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<Entry> {

    private int index = 0;
    private Iterator<Entry> it = (arr.getAt(0)).iterator();

    @Override
    public boolean hasNext() {
      while (!it.hasNext()) {
        if (index == M - 1) return false;
        it = arr.getAt(++index).iterator();
      }
      return true;
    }

    @Override
    public HashTable<K, V>.Entry next() {
      return it.next();
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[\n");
    for (LinkedList<Entry> linkedList : arr) {
      sb.append("\t").append(linkedList).append(",\n");
    }
    return sb.append("]").toString();
  }
}
