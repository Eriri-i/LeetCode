package algorithm.linkedlist;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/17
 */
public class LeetCode206 {
    /**
     * LeetCode 206 反转链表
     * <p>
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * @param head 单链表的头节点
     * @return 反转后的链表头结点
     */
    public ListNode reverseList(ListNode head) {
        return iterativeSolution(head);
    }

    private ListNode iterativeSolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous =null;
        while (current.next != null) {
            ListNode next = current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        current.next=previous;
        return current;
    }
    private ListNode recursiveSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = recursiveSolution(head.next);
        // head.next 是反转后的链表的最后一个节点
        // 将 head 链接到 head.next
        head.next.next = head;
        // head 为最后一个节点，head.next 设置为 null
        head.next = null;
        return reversedHead;
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
