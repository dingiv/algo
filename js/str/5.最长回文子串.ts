/*
 * @lc app=leetcode.cn id=5 lang=typescript
 *
 * [5] 最长回文子串
 */

// @lc code=start
function longestPalindrome(s: string): string {
	const size = s.length
	const dp = new Array(size).fill(undefined).map(x => [false])
	let maxBeg = 0, maxLen = 1
	for (let i = 0; i < size; ++i) {
		dp[i][i] = true
		if (s[i] !== s[i + 1]) continue
		dp[i][i + 1] = true
		maxBeg = i
		maxLen = 2
	}

	for (let len = 3; len <= size; ++len) {
		for (let beg = 0; beg + len <= size; ++beg) {
			const end = beg + len - 1
			if (dp[beg + 1][end - 1] && s[beg] === s[end]) {
				dp[beg][end] = true
				if (len > maxLen) {
					maxLen = len
					maxBeg = beg
				}
			} else {
				dp[beg][end] = false
			}
		}
	}
	return s.substring(maxBeg, maxBeg + maxLen)
};
// @lc code=end

console.log(longestPalindrome('cbbd'))
