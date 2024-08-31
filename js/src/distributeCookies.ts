/*
* @lc app=leetcode.cn id=2305 lang=typescript
*
* [860] 柠檬水找零
*/
// @lc code=start

function distributeCookies(cookies: number[], k: number) {
    arr = cookies
    kid = k
    let sum: number[] = []
    sum.length = k
    sum.fill(0, 0)
    dfs(cookies.length - 1, sum)
    return min
}

let arr: number[] = []
let kid = 0
let min = 10e5
let tmp = 0

function dfs(depth: number, sum: number[]) {
    if ((tmp = Math.max(...sum)) >= min) return
    if (depth >= 0) {
        for (let i = 0; i < kid; ++i) {
            sum[i] += arr[depth]
            dfs(depth - 1, sum)
            sum[i] -= arr[depth]
        }
    } else min = tmp
}


// @lc code=end

console.log(distributeCookies([11,6,14,4], 2))


export default {}