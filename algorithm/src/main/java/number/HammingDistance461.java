package number;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName hammingDistance461
 * @Date 2019-06-28 17:38
 * 461.汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 **/
public class HammingDistance461 {

    /**
     * @Date 2019-06-28 17:38
     * @param  x
     * @param  y
     * @return int
     *
     **/
    public int hammingDistance(int x, int y) {
        //bitCount 数出整数二进制下 1 的个数
        //1^0 = 1 ,0^1 =1 ,0^0 = 0 ,1^1 = 0
        return Integer.bitCount(x^y);
    }
}
