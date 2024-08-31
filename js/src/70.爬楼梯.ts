/*
 * @lc app=leetcode.cn id=70 lang=typescript
 *
 * [70] 爬楼梯
 */

// @lc code=start

function climbStairs(n: number): number {
	const dp = [1, 1]
	if (dp[n]) return dp[n]
	for (let i = dp.length; i <= n; ++i) {
		dp[i] = dp[i - 1] + dp[i - 2]
	}
	return dp[n]
};


// @lc code=end

console.log(climbStairs(35))

