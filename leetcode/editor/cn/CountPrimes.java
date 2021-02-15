//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 624 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 线性筛的应用，加入primes数组统计所有的素数，对于所有的数字都乘以对应的素数后设置为合数，遇到该数余primes数组的时候为0，break循环设置为合数
 * @author yoyoki
 * @date 2021/2/10 6:01 下午
 */
public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int countPrimes(int n) {
            List<Integer> primes = new ArrayList<Integer>();
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] == 1) {
                    primes.add(i);
                }
                for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                    isPrime[i * primes.get(j)] = 0;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            return primes.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}