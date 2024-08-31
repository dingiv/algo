/*
 * @lc app=leetcode.cn id=1223 lang=typescript
 *
 * [1223] 掷骰子模拟
 */

// @lc code=start

const MOD = 1e9 + 7
let maxs: number[]
const dp: number[][][] = []

function dieSimulator(n: number, rollMax: number[]): number {
    maxs = rollMax
    for (let i = 0; i < n; ++i) {
        dp[i] = []
        for (let j = 0; j < 6; ++j) {
            dp[i].push([])
        }
    }
    return dfs(n, 0, rollMax[0])
}

function dfs(depth: number, prev: number, remain: number): number {
    if (depth-- == 0) return 1
    if (dp[depth][prev][remain] >= 0) return dp[depth][prev][remain]
    let ans = 0
    for (let i = 0; i < 6; ++i) {
        if (i != prev) ans += dfs(depth, i, maxs[i] - 1)
        else if (remain > 0) ans += dfs(depth, i, remain - 1)
    }
    return dp[depth][prev][remain] = ans % MOD
}

// @lc code=end


console.log(dieSimulator(2, [1, 1, 2, 2, 2, 3]))




`
    记忆化搜索
`

// const MOD = 1e9 + 7
// let maxs: number[]
// const dp: number[][][] = []

// function dieSimulator(n: number, rollMax: number[]): number {
//     maxs = rollMax
//     let ans = 0

//     dfs(n, 0, rollMax[0])

//     return ans
// }


// function dfs(depth: number, prev: number, remain: number): number {
//     if (depth === 0) return depth
//     if (dp[depth][prev][remain] > 0) return dp[depth][prev][remain]
//     let ans = 0

//     for (let i = 0; i < 6; ++i) {
//         if (i != prev) ans += dfs(depth - 1, i, maxs[i] - 1)
//         else if (remain > 0) ans += dfs(depth - 1, i, remain - 1)

//     }
//     return dp[depth][prev][remain] = ans % MOD

// }

