package algorithm.bfs;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/24
 */
public class LeetCode111 {

    /**
     * LeetCode 711 二叉树的最小深度
     *
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     *
     * 解题：BFS一般用来计算，从起点到终点之间的距离 本题需要用到一个队列存储节点下一步要访问的节点，采用合适的方式遍历这个队列可以得到答案
     * @param root 二叉树的根节点
     * @return 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        // 特殊情况
        if (root == null) {
            return 0;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 树起始高度
        int deep = 1;
        // 根结点入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 遍历树的每一层所有节点
            for (int i = 0; i < sz; i++) {
                // 出队列
                TreeNode node = queue.poll();
                // 到达叶子节点,直接返回树高度
                if (node.left == null && node.right == null) {
                    return deep;
                }
                // 没有到达叶子节点
                if (node.left != null) {
                    // 子节点入队列
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    // 子节点入队列
                    queue.offer(node.right);
                }
            }
            // 这一层遍历完了，树高度增加
            deep++;
        }
        return deep;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
