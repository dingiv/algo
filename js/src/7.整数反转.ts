/*
 * @lc app=leetcode.cn id=7 lang=typescript
 *
 * [7] 整数反转
 */

// @lc code=start
const min = 2 ** 31 * -1, max = 2 ** 31 - 1;
function reverse(x: number): number {
	const sign = x < 0 ? -1 : 1
	x = Math.abs(x)

	let res = 0
	while (x > 0) {
		res = res * 10 + x % 10
		x = Math.floor(x / 10)
	}

	const result = res * sign
	if (result < min || result > max) return 0
	return res * sign
};
// @lc code=end

console.log(reverse(234))


export { reverse }