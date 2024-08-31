/*
* @lc app=leetcode.cn id=771 lang=javascript
*
* [860] 柠檬水找零
*/
// @lc code=start
/**
 * @param {string} jewels
 * @param {string} stones
 * @return {number}
 */
var numJewelsInStones = function (jewels, stones) {
    let ans = 0
    let set = 0n
    let tmp = 0n;
    for (let i = 0; i < jewels.length; ++i) set |= 1n << BigInt(jewels.charCodeAt(i) - 65)
    for (let i = 0; i < stones.length; ++i) {
        tmp = BigInt(stones.charCodeAt(i) - 65)
        if ((set >> tmp & 1n) == 1n) ans += 1
    }
    return ans

    // const ar1 = jewels.split('')
    // const ar2 = stones.split('')
    // return (ar2.filter((str) => ar1.includes(str))).length
}
// @lc code=end


// console.log(numJewelsInStones("ABC", "dsfASBBC"))
