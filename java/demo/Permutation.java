package day04;


// 46.排列组合，递归实现

import java.util.Arrays;

public class Permutation {

    int[] arr = null;
    int[] ret = null;
    int cursor = 0;

    Permutation(int[] arr) {
        this.arr = arr;
    }

    void swap(int left, int right) {
        cursor = arr[left];
        arr[left] = arr[right];
        arr[right] = cursor;
    }

    void swap(int[] arr, int left, int right) {
        cursor = arr[left];
        arr[left] = arr[right];
        arr[right] = cursor;
    }

    void permute() {
        permute(0, arr.length - 1);
    }

    // 全排列代码
    void permute(int beg, int end) {
        if (beg != end) {
            for (int i = beg; i <= end; ++i) {
                swap(beg, i);
                permute(beg + 1, end);
                swap(beg, i);
            }
        } else {
            // 在过渡区处理每一种排列情况的数组，对其进行操作
            System.out.println(Arrays.toString(arr));
        }
    }

    void permute(int[] arr, int beg, int end) {
        if (beg != end) {
            for (int i = beg; i <= end; ++i) {
                swap(arr, beg, i);
                permute(arr, beg + 1, end);
                swap(arr, beg, i);
            }
        } else {
            // 在过渡区处理每一种排列情况的数组，对其进行操作
            System.out.println(Arrays.toString(arr));
        }
    }

    void combine(int n) {
        if (n > arr.length || n < 1) return;
        ret = new int[n];
        combine(n - 1, 0, arr.length - 1);
    }

    void combine(int n, int beg, int end) {
        for (int i = beg; i <= end - n; ++i) {
            ret[n] = arr[i];
            if (n > 0) {
                combine(n - 1, i + 1, end);
            } else {
                System.out.println(Arrays.toString(ret));
            }
        }
    }

    void permute(int n) {
        if (n > arr.length || n < 1) return;
        ret = new int[n];
        permute(n - 1, 0, arr.length - 1);
    }

    void permute(int n, int beg, int end) {
        for (int i = beg; i <= end - n; ++i) {
            ret[n] = arr[i];
            if (n > 0) {
                permute(n - 1, i + 1, end);
            } else {
//                System.out.println(Arrays.toString(ret) + "-----------------");
                permute(ret, 0, ret.length - 1);
            }
        }
    }
}
