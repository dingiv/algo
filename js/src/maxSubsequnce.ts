/*
 * @lc app=leetcode.cn id=53 lang=typescript
 *
 * [53] 最大子数组和
 */

// @lc code=start
function maxSubArray(input:number[]) {
    let prev = input[0], max = prev
    for (let i = 1; i < input.length; ++i) {
        if (prev >= 0) prev = prev + input[i];
        else prev = input[i]
        if (prev > max) max = prev
    }
    return max
};
// @lc code=end

const input = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

// dp[i][j]表示长度为i+1的子序列，第j+1个子序列的大小；

// const dp: number[][] = []

// function sum(beg: number, end: number) {
//     let tmp = 0
//     while (beg <= end) {
//         tmp += input[beg++]
//     }
//     return tmp
// }

// for (let i = 0; i < input.length; ++i) {
//     dp.push([])
//     for (let j = 0; j + i < input.length; ++j) {
//         dp[i][j] = sum(j, j + i);
//     }
// }


// 优化空间和时间

// const dp: number[] = input.map(x => x)
// let max = Math.max(...input)
// for (let i = 1; i < input.length; ++i) {
//     for (let j = 0; j + i < input.length; ++j) {
//         dp[j] = dp[j] + input[j + i];
//         max = Math.max(max, dp[j])
//     }
// }


// 再次优化，优化思路，状态的定义方式发生改变
// 使用dp[i]表示以input[i]结尾的子序列中最大的那个
// const dp = [input[0]]
// for (let i = 1; i < input.length; ++i) {
//     if (dp[i - 1] >= 0) dp[i] = dp[i - 1] + input[i];
//     else dp[i] = input[i]
// }

// let max = dp[0]
// for (let i = 0; i < input.length; ++i) {
//     if (dp[i] > max) max = dp[i]
// }

// console.log(max)


// 再次优化，使用递换思路，将空间进行优化，对dp进行降维

let prev = input[0], max = prev
for (let i = 1; i < input.length; ++i) {
    if (prev >= 0) prev = prev + input[i];
    else prev = input[i]
    if (prev > max) max = prev
}
 