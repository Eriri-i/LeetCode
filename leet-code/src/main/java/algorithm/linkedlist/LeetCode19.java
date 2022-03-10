package algorithm.linkedlist;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/10
 */
public class LeetCode19 {
    /**
     * LeetCode 19 删除链表倒数的第N个结点
     *
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * @param head 链表的头结点
     * @param n 第n个节点
     * @return 链表的头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fast = head;
//        ListNode slow = head;
//        ListNode slowPre = head;
//        for (int i = n-1; i > 0; i--) {
//            // 表示走到头了
//            if (fast.next == null) {
//                return head.next;
//            }
//            fast=fast.next;
//        }
//        int count=0;
//        while (fast.next != null) {
//            if (count != 0) {
//                slowPre=slowPre.next;
//            }
//            slow=slow.next;
//            fast=fast.next;
//            count++;
//        }
//        slowPre.next=slow.next;
        return head;
    }

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
}
