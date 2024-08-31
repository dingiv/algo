package day03;

public class Selection<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        T cursor = null;
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j].compareTo(arr[min]) < 0) min = j;
            }
            cursor = arr[min];
            arr[min] = arr[i];
            arr[i] = cursor;
        }
    }

}