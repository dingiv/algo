package day01;

import java.util.Stack;

// 递归写法
class Recrusion {

    static int func() {
        // 公共区，用于控制条件的计算
        boolean condition = true;

        if (condition) {
            // 纵深区，

            int ret = func();
            // 回归区，使用起始返回值和中间返回值计算并继续返回中间返回值

            return 1;
        } else {
            // 过渡区，只执行一次，计算起始返回值

            return 2;
        }
    }

    static Integer loop() {
        Stack<Integer> stack = new Stack<Integer>();
        while (true) {
            // 公共区
            boolean condition = true;

            // 条件控制
            if (condition) {
                // 纵深区

                stack.push(1);
            } else {
                // 过渡区

                stack.push(2);
                break;
            }
        }

        Integer ret = null;
        while (stack.size() > 0) {
            // 回归区
            int data = stack.pop();
        }
        return ret;
    }

    static Integer loop_without_pub() {
        Stack<Integer> stack = new Stack<Integer>();
        boolean condition = true;
        while (condition) {
            // 纵深区

            stack.push(1);
        }
        // 过渡区

        Integer ret = null;
        while (stack.size() > 0) {
            // 回归区
            int data = stack.pop();
        }
        return ret;
    }

    static int fun(int n) {
        // 公共区
        boolean condition = n > 1;

        // 条件控制
        if (condition) {
            // 纵深区
            int m = n - 1;
            int ret = fun(m);
            // 回归区
            ret *= n;
            return ret;
        } else {
            // 过渡区
            int ret = 1;
            return ret;
        }
    }

    static int loo(int n) {

        Stack<Integer> stack = new Stack<Integer>();
        while (true) {
            // 公共区
            boolean condition = n > 1;

            // 条件控制
            if (condition) {
                // 纵深区

                stack.push(n--);
            } else {

                stack.push(1);
                break;
            }
        }

        int ret = 1;
        while (stack.size() > 0) {
            // 回归区
            ret *= stack.pop();
        }

        return ret;
    }

    static int fun2(int n) {
        if (n > 1)
            return fun2(n - 1) * n;
        else
            return 1;
    }

    static int loo2(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int ret = 1;
        while (n > 1)
            stack.push(n--);
        while (stack.size() > 0)
            ret *= stack.pop();
        return ret;
    }

    static int direct(int n) {
        int ret = 1;
        while (n > 1)
            ret *= n--;
        return ret;
    }

}
