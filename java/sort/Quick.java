package day03;

public class Quick<T extends Comparable<T>> implements Sort<T> {

    // 切分的逻辑
    private final int DIVIDE_THRESHOLD = 2;

    T cursor = null;

    void wrap(T[] arr, int a, int b) {
        cursor = arr[a];
        arr[a] = arr[b];
        arr[b] = cursor;
    }

    @Override
    public void sort(T[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    private void partition(T[] arr, int beg, int end) {
        if (end - beg > DIVIDE_THRESHOLD) {
            // 获取基准，位于中间的数
            T temp = arr[(beg + end) / 2];
            arr[(beg + end) / 2] = arr[beg];

            // 一趟分割
            int i = beg, j = end + 1;
            while (true) {
                while (arr[++i].compareTo(temp) < 0)
                    if (i == end) break;
                while (arr[--j].compareTo(temp) > 0)
                    if (j == beg) break;
                if (i >= j) break;
                wrap(arr, j, i);
            }

            // 把分隔数返回中间位
            arr[beg] = arr[j];
            arr[j] = temp;

            // 继续分割
            partition(arr, beg, j - 1);
            partition(arr, j + 1, end);
        } else {
            // 此处写排序的算法
            // 小数组排序，可以在此处换用其他算法，典型的如插入排序
            if (end - beg == 1 && arr[beg].compareTo(arr[end]) > 0) {
                wrap(arr, end, beg);
            }
        }
    }

}
