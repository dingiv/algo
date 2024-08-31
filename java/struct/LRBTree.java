package day02;

import java.util.Iterator;

public class LRBTree<T extends Comparable<T>> implements Iterable<T> {

  private final boolean RED = true;
  private final boolean BLACK = false;

  private class Node implements Comparable<Node> {

    T data = null;
    Node left = null;
    Node right = null;
    boolean color = RED;

    Node(T data, boolean color) {
      this.data = data;
      this.color = color;
    }

    @Override
    public String toString() {
      return "{" + (color ? "r: " : "b: ") + data + "}";
    }

    @Override
    public int compareTo(LRBTree<T>.Node o) {
      return data.compareTo(o.data);
    }
  }

  private Node root = null;
  private int size = 0;

  public int size() {
    return size;
  }

  public LRBTree() {}

  // 插入逻辑
  public void put(T data) {
    // 递归调用添加新的节点
    root = put(root, data);
    root.color = BLACK;
    size++;
  }

  private Node put(Node node, T data) {
    if (node == null) return new Node(data, RED);

    int cmp = data.compareTo(node.data);
    if (cmp < 0)
      node.left = put(node.left, data);
    else if (cmp > 0)
      node.right = put(node.right, data);
    else
      node.data = data;

    if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right)) flipColors(node);

    return node;
  }

  private boolean isRed(Node node) {
    return node != null && node.color == RED;
  }

  private Node rotateLeft(Node node) {
    Node x = node.right;
    node.right = x.left;
    x.left = node;
    x.color = node.color;
    node.color = RED;
    return x;
  }

  private Node rotateRight(Node node) {
    Node x = node.left;
    node.left = x.right;
    x.right = node;
    x.color = node.color;
    node.color = RED;
    return x;
  }

  private void flipColors(Node node) {
    node.color = RED;
    node.left.color = BLACK;
    node.right.color = BLACK;
  }

  // 删除逻辑
  public boolean isExist(T data) {
    Node cursor = root;
    int cmp = 0;
    while (cursor != null) {
      cmp = data.compareTo(cursor.data);
      if (cmp < 0)
        cursor = cursor.left;
      else if (cmp > 0)
        cursor = cursor.right;
      else
        return true;
    }
    return false;
  }

  public boolean delete(T data) {
    if (!isExist(data)) return false;
    if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
    root = delete(root, data);
    if (root != null) root.color = BLACK;
    return true;
  }

  private Node delete(Node node, T data) {
    if (data.compareTo(node.data) < 0) { // 向左纵深
      if (!isRed(node.left) && !isRed(node.left.left)) node = removeNode2x(node);
      node.left = delete(node.left, data);
    } else { // 向右纵深
      if (isRed(node.left)) node = rotateRight(node);
      if (node.right == null) return null; // 命中的节点在树根，直接删除
      if (!isRed(node.right) && !isRed(node.right.left)) {
        node = removeNode2x(node);
      }
      if (data.compareTo(node.data) > 0) { // 向右纵深
        node.right = delete(node.right, data);
      } else { // 命中删除目标
        Node cursor = node.right;
        while (cursor.left != null) {
          cursor = cursor.left;
        }
        node.data = cursor.data;
        node.right = deleteMin(node.right);
      }
    }
    return balance(node);
  }

  // 消除2-节点
  private Node removeNode2x(Node node) {
    node.color = BLACK;
    node.left.color = RED;
    node.right.color = RED;
    if (isRed(node.right.left)) {
      node.right = rotateRight(node.right);
      node = rotateLeft(node);
    }
    return node;
  }

  // 平衡删除后的节点
  private Node balance(Node node) {
    if (isRed(node.right)) node = rotateLeft(node);
    // if (isRed(node.right) && !isRed(node.left))
    // node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right)) flipColors(node);
    return node;
  }

  // 删除最小值
  private Node deleteMin(Node node) {
    if (node.left == null) return null;
    if (!isRed(node.left) && !isRed(node.left.left)) node = removeNode2x(node);
    node.left = deleteMin(node.left);
    return balance(node);
  }

  // 遍历逻辑
  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T> {

    ArrayList<T> arr = new ArrayList<>();
    int index = 0;

    public MyIterator() {
      iterate(root);
    }

    private void iterate(Node node) {
      if (node != null) {
        iterate(node.left);
        arr.add(node.data);
        iterate(node.right);
      }
    }

    @Override
    public boolean hasNext() {
      return index < arr.size();
    }

    @Override
    public T next() {
      return arr.getAt(index++);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[ ");
    for (var t : this) {
      sb.append(t).append(", ");
    }
    return sb.substring(0, sb.length() - 2) + " ]";
  }
}
