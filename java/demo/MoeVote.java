package day04;
import java.util.Stack;


// 字节面试题，莫尔投票法，求数组中出现次数过半的数字。

public class MoeVote {


    int generate(int[] arr, int n) {
        var stack = new Stack<Integer>();
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }

 

        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            int[] tmpAr = hasSmaller(arr, tmp);
            if (tmpAr[0] > 0) {

                

            } else if (tmpAr[0] == 0) {

            }
        }

        System.out.println(stack);
        return 0;
    }

    int[] hasSmaller(int[] arr, int n) {
        int[] ret = new int[]{-1, 0};
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < n) {
                ret[0] = 1;
                ret[1] = arr[i];
            } else if (arr[i] == n) {
                ret[0] = 0;
                ret[1] = arr[i];
            } else break;
        }
        return ret;
    }
}
