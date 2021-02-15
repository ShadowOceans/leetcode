//给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。 
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 示例 1: 
//
// 
//输入: "123"
//输出: "121"
// 
//
// 注意: 
//
// 
// n 是由字符串表示的正整数，其长度不超过18。 
// 如果有多个结果，返回最小的那个。 
// 
// Related Topics 字符串 
// 👍 87 👎 0

public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        Solution solution = new FindTheClosestPalindrome().new Solution();
        System.out.println(solution.nearestPalindromic("1000"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nearestPalindromic(String n) {
            if (Long.parseLong(n) <= 10L){
                return String.valueOf((Long.parseLong(n) -1 ));
            }
            if (Long.parseLong(n) <= 11L){
                return String.valueOf(9);
            }
            String mid = n.substring(0, (n.length() + 1) / 2);
            StringBuilder midBuilder = new StringBuilder(mid).reverse();
            Long midFrontReverse = Long.parseLong(midBuilder.toString());
            Long midBack = Long.parseLong(new StringBuilder(n.substring(n.length() / 2)).toString());
            long a = 0L;
            long b = 0L;
            long c = 0L;
            long d = Long.parseLong(n);
            if ((n.length() & 1) == 0) {
                a = Long.parseLong(mid + midBuilder.toString());
            } else {
                a = Long.parseLong(mid + midBuilder.substring(1));
            }

            String resultStr = String.valueOf((Long.parseLong(mid.toString()) - 1));
            StringBuilder resultStrBuilder = new StringBuilder(resultStr);
            StringBuilder resultStrReverse = resultStrBuilder.reverse();
            if ((n.length() & 1) == 0 ) {
                if (resultStr.length() == mid.length()){
                    b = Long.parseLong(resultStr + resultStrReverse.toString());
                }else {
                    b = Long.parseLong(resultStr +"9"+ resultStrReverse.toString());
                }
            } else {
                if (resultStr.length() == mid.length()){
                    b = Long.parseLong(resultStr + resultStrReverse.toString().substring(1));
                }else {
                    b = Long.parseLong(resultStr + resultStrReverse.toString());
                }
            }

            String resultStr2 = String.valueOf((Long.parseLong(mid.toString()) + 1));
            StringBuilder resultStrBuilder2 = new StringBuilder(resultStr2);
            StringBuilder resultStrReverse2 = resultStrBuilder2.reverse();
            if ((n.length() & 1) == 0) {
                if (resultStr2.length() == mid.length()){
                    c= Long.parseLong(resultStr2 + resultStrReverse2.toString());
                }else {
                    c = Long.parseLong(resultStr2 + resultStrReverse2.toString().substring(1));
                }
            } else {
                if (resultStr2.length() == mid.length()){
                    c= Long.parseLong(resultStr2 + resultStrReverse2.toString().substring(1));
                }else {
                    c= Long.parseLong(resultStr2 + resultStrReverse2.toString().substring(2));
                }
            }

            if (a == d){
                a = 0L;
            }

            int min = Integer.MAX_VALUE;
            String result = "";
            if ( Math.abs(b- d)< min ){
                min = (int) Math.abs(b- d);
                result = String.valueOf(b);
            }
            if ( Math.abs(a- d)< min ){
                min = (int) Math.abs(a- d);
                result = String.valueOf(a);
            }
            if ( Math.abs(c- d)< min ){
                min = (int) Math.abs(c- d);
                result = String.valueOf(c);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}