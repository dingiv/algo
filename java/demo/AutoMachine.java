package day05;

public class AutoMachine {
    // 当前状态
    public byte state = 0 /* q0 : 起始状态 */;

    // 状态表
    /*
     * q0 : 0
     * F1 : 1
     * F2 : 2
     * ......
     * 
     */

    // 字母表
    /*
     * a : 0
     * b : 1
     * c : 2
     * 
     * .......
     */

    // 转移矩阵
    public byte[][] table = null;

    /*
     * 或者写成
     * public Transfer[][] table = null;
     * 
     * interface Transfer {
     * byte transform();
     * }
     * 
     */

    public byte getAlpha(char c /* c = 'a' */ ) {
        return 0; /* a : 0 */
    }

    byte transform(byte input /* input = a / b / c */) {
        return state;
    }
}
