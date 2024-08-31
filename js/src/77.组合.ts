/*
 * @lc app=leetcode.cn id=77 lang=typescript
 *
 * [77] 组合
 */

// @lc code=start
let n = 0, k = 0
let used: boolean[] = [], ret: number[][] = []
function combine(_n: number, _k: number): number[][] {
	n = _n, k = _k, ret = []
	used = new Array(n).fill(false)
	dfs(0, 0)
	return ret
}
function dfs(count: number, start: number) {
	/*
	  递归的深度由当前选中了几个数来决定，这样可以减少递归深度
	*/
	if (count < k) {
		const end = n - (k - count) + 1
		/*
		  遍历从当前start数开始的之后的数字
		*/
		for (let i = start; i < end; ++i) {
			if (used[i]) continue
			used[i] = true
			dfs(count + 1, i + 1)
			used[i] = false
		}
	} else {
		const tmp: number[] = []
		used.forEach((x, id) => x && tmp.push(id + 1))
		ret.push(tmp)
	}
}

// @lc code=end

console.log(combine(4, 2))
export default combine