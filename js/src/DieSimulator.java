package day06;
/*
 * @lc app=leetcode.cn id=1223 lang=java [1223] 掷骰子模拟
 */

import java.util.Arrays;

// @lc code=start
class DieSimulator {
    long mod = 1_000_000_000 + 7;
    int[] rollMax = null;

    public int dieSimulator(int n, int[] rollMax) {
        int max = rollMax[0];
        for (int i = 1; i < 6; ++i) {
            max = max > rollMax[i] ? max : rollMax[i];
        }
        long[][][] dp = new long[n][6][max + 1];
        this.rollMax = rollMax;
        long sum = dfs(0, 0, 0, dp);
        return (int) (sum % mod);
    }

    private long dfs(int n, int prev, int times, long[][][] dp) {
        if (n < dp.length) {
            long tmp = 0;
            for (int i = 0; i < 6; ++i) {
                if (prev == i) {
                    if (times < rollMax[i]) {
                        if (dp[n][prev][times] != 0) tmp += dp[n][prev][times];
                        else tmp += dfs(n + 1, i, times + 1, dp);
                    }
                } else tmp += dfs(n + 1, i, 0, dp);
            }
            dp[n][prev][times] = tmp;
            return tmp;
        } else {
            return 1;
        }
    }
    // private
}
// @lc code=end
