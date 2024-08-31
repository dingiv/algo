/*
 * @lc app=leetcode.cn id=718 lang=typescript
 *
 * [718] 最长重复子数组
 */

// @lc code=start
function findLength(nums1: number[], nums2: number[]): number {
    let ans = 0
    const dp = makeDp(nums1, nums2)
    for (let i = 0; i < nums1.length; i++) {
        for (let j = 0; j < nums2.length; j++) {
            if (nums1[i] === nums2[j]) {
                if (i === 0 || j === 0) dp[i][j] = 1
                else dp[i][j] = dp[i - 1][j - 1] + 1
            }
            ans = Math.max(dp[i][j], ans)
        }
    }
    return ans
};

function makeDp(nums1: number[], nums2: number[]) {
    let dp: number[][] = new Array(nums1.length + 1)
    dp = dp.fill([]).map(x => new Array(nums2.length + 1).fill(0))
    return dp
}

// @lc code=end