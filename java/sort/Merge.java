package day03;

import java.util.Arrays;
// import java.util.List;

public class Merge<T extends Comparable<T>> implements Sort<T> {

    // 模式 采用自上而下，还是自下而上
    private int MODE = 1;// from top to bottom
    // static final int MODE = 2; // from bottom to top

    // 切分阈值
    private int DIVIDE_THRESHOLD = 2;

    public Merge() {}

    public Merge(int MODE) {
        this.MODE = MODE;
    }

    // 归并排序
    // 自顶向下的归并需要进行递归调用，而自底向上的归并无需进行递归
    @Override
    public void sort(T[] arr) {
        tmp = Arrays.copyOf(arr, arr.length);
        if (MODE == 1) {
            divide(arr, 0, arr.length - 1);
        } else {
            reduce(arr);
        }
    }

    T cursor = null;

    void wrap(T[] arr, int a, int b) {
        cursor = arr[a];
        arr[a] = arr[b];
        arr[b] = cursor;
    }

    // 切分的逻辑
    private void divide(T[] arr, int beg, int end) {
        // 典型的递归，二叉递归
        if (end - beg > DIVIDE_THRESHOLD) {
            int mid = (beg + end) / 2;
            divide(arr, beg, mid);
            divide(arr, mid + 1, end);
            mergeUp(arr, beg, mid, end);
        } else {
            // 此处写排序的算法
            // 小数组排序，可以在此处换用其他算法，典型的如插入排序
            if (end - beg == 1 && arr[beg].compareTo(arr[end]) > 0) {
                wrap(arr, end, beg);
            }
        }
    }

    private void reduce(T[] arr) {
        for (int i = 0, sz = DIVIDE_THRESHOLD; i < arr.length; i += sz) {
            // 此处写排序的算法
            // 小数组排序，可以在此处换用其他算法，典型的如插入排序
            if (i + 1 < arr.length && arr[i].compareTo(arr[i + 1]) > 0) {
                wrap(arr, i, i + 1);
            }
        }

        // 自底向上将切分的最小数组层层归并
        for (int sz = DIVIDE_THRESHOLD; sz < arr.length; sz *= 2) {
            for (int beg = 0; beg < arr.length - sz; beg += sz + sz) {
                mergeUp(arr, beg, beg + sz - 1, Math.min(beg + sz + sz - 1, arr.length - 1));
            }
        }
    }

    // 归并辅助函数
    private T[] tmp = null;

    private void mergeUp(T[] arr, int beg, int mid, int end) {
        // 如果前者的最大值小于后者最小值则说明，二者已经有序，则无需继续归并
        if (arr[mid].compareTo(arr[mid + 1]) < 0) return;

        // 拷贝元素到临时空间
        for (int i = beg; i <= end; ++i) {
            tmp[i] = arr[i];
        }

        // 将元素归并回原处
        for (int i = beg, j = mid + 1; i <= mid || j <= end;) {
            if (i > mid) arr[beg++] = tmp[j++];
            else if (j > end) arr[beg++] = tmp[i++];
            else if (tmp[i].compareTo(tmp[j]) <= 0) arr[beg++] = tmp[i++];
            else arr[beg++] = tmp[j++];
        }
    }

}
