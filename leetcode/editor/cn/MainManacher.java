/**
 * @Description: 马拉车算法，多用于求解一个字符串中的最长的回文串的最优解，类似的求解方式还有hash，以及kmp
 * @ClassName: MainManacher
 * @Author: yoyoki
 * @Date: 2021/2/11 1:13 上午
 * @Version: 1.0
 */

import java.util.Scanner;

public class MainManacher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(maxLcpsLength(str));
    }

    /**
     * @param str
     * @return char[]
     * @description 构建res数组（长度为2n+1），并用#号填充str
     * @author yoyoki
     * @date 2021/2/11 1:14 上午
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    /**
     * @param str
     * @return int
     * @description 传入Str
     * @author yoyoki
     * @date 2021/2/11 1:16 上午
     */
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() <= 0)
            return 0;
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = -1;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i - pArr[i]] == charArr[i + pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }

            if (max < pArr[i] - 1)
                max = pArr[i] - 1;
        }
        return max;
    }
}