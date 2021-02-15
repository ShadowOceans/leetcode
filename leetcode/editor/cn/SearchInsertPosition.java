//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 815 👎 0
/**
 * @description 二分查找有序数组的中位数，或者插入
 * @author yoyoki
 * @date 2021/2/10 3:30 上午
 */
public class SearchInsertPosition {

    /**
     *
     * @leetcodeLink : https://leetcode-cn.com/problems/search-insert-position/
     * @author yoyoki
     * @param args
     * @return void
     * @date 2021/2/10 3:24 上午
     */
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] arr = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(arr, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return midSearchInsert(0, nums.length - 1, nums, target);
        }

        /**
         * @description 通过二分查找对应的中位值，当start == end的时候，返回对应插入的下标或者查找的下标
         * @author yoyoki
         * @param start
         * @param end
         * @param array
         * @param target
         * @return int
         * @date 2021/2/10 3:29 上午
         */
        public int midSearchInsert(int start, int end, int[] array, int target) {
            if (start < end) {
                int mid = (start + end) / 2;
                if (array[mid] < target) {
                    return midSearchInsert(mid + 1, end, array, target);
                } else {
                    return midSearchInsert(start, mid - 1, array, target);
                }
            } else {
                if (array[start] < target){
                    return start + 1;
                }
                else {
                    return start ;
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}