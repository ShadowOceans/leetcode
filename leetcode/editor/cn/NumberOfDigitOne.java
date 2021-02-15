//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 数学 
// 👍 198 👎 0
/**
 * @description  给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * @author yoyoki
 * @date 2021/2/12 7:20 下午
 */
public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        System.out.println(solution.countDigitOne(1234));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int count = 0;
            for (int i = 1; i <= n; i *= 10) {
                int divider = i * 10;
                count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}