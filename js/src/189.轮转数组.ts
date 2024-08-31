/*
 * @lc app=leetcode.cn id=189 lang=typescript
 *
 * [189] 轮转数组
 */

// @lc code=start
/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): void {
    // const len = nums.length
    // k = k % len
    // if (k <= 0) return
    // const tmp = nums[len - k]
    // for (let i = 0; i < len; ++i) {

    // }

    const tmp = nums.splice(nums.length - k % nums.length)
    nums.unshift(...tmp)
};
// @lc code=end

let nums = [-1, -100, 3, 99]
// nums = [1, 2, 3, 4, 5, 6, 7]
console.log(rotate(nums, 2))
console.log(nums)
