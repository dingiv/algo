/*
* @lc app=leetcode.cn id=860 lang=typescript
*
* [860] 柠檬水找零
*/
// @lc code=start
function lemonadeChange(bills: number[]): boolean {
    let _5dallars = 0
    let _10dallars = 0
    let _20dallars = 0

    for (let i = 0; i < bills.length; ++i) {
        switch (bills[i]) {
            case 5:
                _5dallars++
                break
            case 10:
                if (_5dallars <= 0) return false
                _10dallars++
                _5dallars--
                break
            default:
                if (_10dallars > 0 && _5dallars > 0) {
                    _5dallars--
                    _10dallars--
                } else if (_10dallars <= 0 && _5dallars >= 3) {
                    _5dallars -= 3
                } else return false
                _20dallars++
                break
        }
    }

    return true
};
// @lc code=end