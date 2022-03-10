package algorithm.linkedlist;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/10
 */
public class LeetCode23 {
    /**
     * LeetCode 23 合并K和升序列表
     *
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * @param lists 链表数组
     * @return 合并和的链表数组
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        // 指针
        ListNode p = dummy;

        // 优先队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        // 将头节点加入到优先队列
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        Collections.addAll(pq, lists);

        while (!pq.isEmpty()) {
            // 取出最小节点，接到结果链表中
            ListNode poll = pq.poll();
            p.next = poll;
            if (poll.next != null) {
                pq.add(poll.next);
            }
            // p指针往前走
            p = p.next;
        }
        return dummy.next;
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

