package day02;

// 大顶堆实现
public class Heap<T extends Comparable<T>> {
   private T[] arr = null;

   public static int capacity = 8;

   private int size = 0;

   private T cursor = null;

   public int getSize() {
      return size;
   }

   public Heap() {
      arr = (T[]) new Object[capacity];
   }

   public Heap(T[] arr) {
      size = arr.length;
      arr = (T[]) new Object[size + capacity];
      for (int i = 1; i <= size; ++i) {
         this.arr[i] = arr[i];
      }

      for (int i = size / 2; i > 0; --i) {
         shiftDown(i, size);
      }
   }

   private void wrap(int i, int j) {
      cursor = arr[i];
      arr[i] = arr[j];
      arr[j] = cursor;
   }

   private void shiftUp(T data) {
      for(int i=size/2;i>0;--i){
         // if(size)
      }
   }

   private void shiftDown(int beg, int end) {
      int left = 2 * beg, right = 2 * beg + 1, bigger = left;
      if (right <= end) {
         bigger = arr[left].compareTo(arr[right]) > 0 ? left : right;
         if (arr[bigger].compareTo(arr[beg]) <= 0) return;
         wrap(beg, bigger);
         shiftDown(bigger, end);
      } else {
         if (left == end && arr[end].compareTo(arr[beg]) > 0) wrap(end, beg);
      }
   }
}
