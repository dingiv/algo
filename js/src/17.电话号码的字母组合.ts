/*
 * @lc app=leetcode.cn id=17 lang=typescript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

const map: Record<string, string> = {
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz'
}

let res: string[] = []
let tmp: string[] = []

function letterCombinations(digits: string): string[] {
    if (!digits) return []
    res = []
    tmp = []
    dfs(0, digits)
    return res
};

function dfs(depth: number, digits: string) {
    for (const char of map[digits[depth]]) {
        tmp[depth] = char
        if (depth + 1 >= digits.length) res.push(tmp.join(''))
        else dfs(depth + 1, digits)
    }
}
// @lc code=end
console.log(letterCombinations('342'))
