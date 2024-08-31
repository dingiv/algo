/*
 * @lc app=leetcode.cn id=9 lang=typescript
 *
 * [9] 回文数
 */

// @lc code=start
function isPalindrome(x: number): boolean {
	if (x < 0) return false
	let tmp = x + ''
	for (let a = 0, b = tmp.length - 1; a <= b; a++, b--) {
		if (tmp[a] !== tmp[b]) return false
	}
	return true
};
// @lc code=end

console.log(isPalindrome(121))
console.log(isPalindrome(1231))
