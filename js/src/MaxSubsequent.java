package day06;

/*
 * @lc app=leetcode.cn id=53 lang=java [53] 最大子数组和
 */
// @lc code=start
 
class Solution {
    public int maxSubArray(int[] input) {
        int prev = input[0], max = prev;
        for (int i = 1; i < input.length; ++i) {
            if (prev >= 0)
                prev = prev + input[i];
            else
                prev = input[i];
            if (prev > max) max = prev;
        }
        return max;
    }
}
// @lc code=end
