package day03;

public class Insertion<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] arr) {
        T cursor = null;
        for (int i = 1; i < arr.length; ++i) {
            cursor = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (cursor.compareTo(arr[j]) < 0) arr[j + 1] = arr[j];
                else break;
                --j;
            }
            arr[j + 1] = cursor;
        }
    }
}
