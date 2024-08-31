package day05;
/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class ValidIPAddress {

    public String validIPAddress(String ip) {
        if (isV4(ip))
            return "IPv4";
        else if (isV6(ip))
            return "IPv6";
        return "Neither";
    }

    private byte[][] tableV4 = {
            { 6, 1, 2, 3, 4, 4, 4, 6, 6 },
            { 5, 6, 6, 6, 6, 6, 6, 0, 6 },
            { 5, 4, 4, 4, 4, 4, 4, 0, 6 },
            { 5, 4, 4, 4, 4, 7, 6, 0, 6 },
            { 5, 5, 5, 5, 5, 5, 5, 0, 6 },
            { 5, 6, 6, 6, 6, 6, 6, 0, 6 },
            { 6, 6, 6, 6, 6, 6, 6, 6, 6 },
            { 5, 5, 5, 5, 5, 5, 6, 0, 6 }
    };

    int tmp = 0;

    private byte[] alphasV4 = { 1, 2, 3, 4, 4, 5, 6, 6, 6, 6, 0, 7, 8 };

    private byte getAlphaV4(char c) {
        tmp = c - '0';
        if (tmp >= 0 && tmp < 10)
            return alphasV4[tmp];
        else if (c == ' ')
            return alphasV4[10];
        else if (c == '.')
            return alphasV4[11];
        else
            return alphasV4[12];
    }

    private byte[][] tableV6 = {
            { 5, 1, 5, 5 },
            { 4, 2, 0, 5 },
            { 4, 3, 0, 5 },
            { 4, 4, 0, 5 },
            { 4, 5, 0, 5 },
            { 5, 5, 5, 5 },
    };

    private byte getAlphaV6(char c) {
        tmp = c - '0';
        if (
            (tmp >= 0 && tmp <= 9) || (tmp >= 17 && tmp <= 22) || (tmp >= 49 && tmp <= 54)
        )
            return 1;
        if (c == ':')
            return 2;
        if (c == ' ')
            return 0;
        return 3;
    }

    byte state = 0, count = 1;

    private boolean isV4(String ip) {
        count = 1;
        state = 0;
        for (var c : ip.toCharArray()) {
            state = tableV4[state][getAlphaV4(c)];
            if (state == 0) count++;
            if (state == 6 || count > 4) return false;
        }
        state = tableV4[state][getAlphaV4(' ')];
        if (state == 5 && count == 4) return true;
        return false;
    }

    private boolean isV6(String ip) {
        count = 1;
        state = 0;
        for (var c : ip.toCharArray()) {
            state = tableV6[state][getAlphaV6(c)];
            if (state == 0) {
                count++;
            }
            if (state == 5 || count > 8)
                return false;
        }
        state = tableV6[state][getAlphaV6(' ')];
        if (state == 4 && count == 8)
            return true;
        return false;
    }

}
// @lc code=end
