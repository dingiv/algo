package day03;

public class Shell<T extends Comparable<T>> implements Sort<T> {

  @Override
  public void sort(T[] arr) {
    int h = 1;
    T cursor = null;
    while (h < arr.length / 3) h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < arr.length; i += h) {
        cursor = arr[i];
        int j = i - h;
        while (j >= 0) {
          if (cursor.compareTo(arr[j]) < 0) {
            arr[j + h] = arr[j];
          } else break;
          j -= h;
        }
        arr[j + h] = cursor;
      }
      h /= 3;
    }
  }
}
