package day04;

public class DoubleIterator {
    private final int[] ar1 = {0, 1, 2, 3};
    private final int[] ar2 = {4, 5, 6, 7, 8, 9};

    class Result {
        int p = (ar1.length + ar2.length - 1) / 2, q = (ar1.length + ar2.length) / 2;

    }

    Result ret = new Result();


    double test() {
        int p = doubleIterate(ret.p);
        int q = doubleIterate(ret.q);
        return (p + q) / 2.0;
    }


    // 标准的双遍历模式，三while循环
    int doubleIterate(int p) {
        int i = 0, j = 0;

        // 双指针遍历
        // 共有部分
        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] < ar2[j]) {
                if (i + j == p) return ar1[i];
                ++i;
            } else {
                if (i + j == p) return ar2[j];
                ++j;
            }
        }
        // 单独的前一个数组的遍历
        while (i < ar1.length) {
            if (i + j == p) return ar1[i];
            ++i;
        }
        // 单独的后一个数组的遍历
        while (j < ar2.length) {
            if (i + j == p) return ar2[j];
            ++j;
        }
        return 0;
    }
}
