//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 👍 527 👎 0

import java.util.List;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * @description 移除单链表中对应的值的元素，需要构建头节点
     * @author yoyoki
     * @date 2021/2/10 4:43 下午
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode header = new ListNode(-1);
            header.next = head;
            ListNode currentNode = header;
            while (currentNode.next != null){
                if (currentNode.next.val == val){
                    currentNode.next = currentNode.next.next;
                }else{
                    currentNode = currentNode.next;
                }
            }
            return header.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}