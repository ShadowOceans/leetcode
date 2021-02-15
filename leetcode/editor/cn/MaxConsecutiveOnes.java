//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 187 👎 0

/**
 * @author wangshuo
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(solution.findMaxConsecutiveOnes(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxLen = 0;
            int start = -1;
            int end = -1;
            int continueFlag = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (continueFlag == 0) {
                        start = i;
                        continueFlag = 1;
                    }
                    end = i;
                } else {
                    continueFlag = 0;
                    int len = end - start + 1;
                    maxLen = Math.max(len, maxLen);
                }
            }
            int len = end - start + 1;
            if (end != -1) {
                maxLen = Math.max(len, maxLen);
            } else {
                maxLen = 0;
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}