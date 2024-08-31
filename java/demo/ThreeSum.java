package day04;

import java.util.ArrayList;
import java.util.Arrays;

// 15.三数之和
// 又是使用双指针遍历的思想
// 并且，使用了先排序的思维来解决问题。

public class ThreeSum {
    void test(int[] arr) {

        Arrays.sort(arr);

        var ret = new ArrayList<Integer[]>();

        for (int i = 0; i < arr.length - 3; ++i) {
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int temp = arr[i] + arr[j] + arr[k];
                if (temp == 0) {
                    ret.add(new Integer[]{arr[i], arr[j], arr[k]});

                    if (j + 1 < k && arr[j + 1] == arr[j]) {
                        j++;
                    } else if (k - 1 > j && arr[k - 1] == arr[k]) {
                        k--;
                    } else {
                        break;
                    }

                } else if (temp < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        ret.forEach((ar) -> System.out.println(Arrays.toString(ar)));
    }
}
