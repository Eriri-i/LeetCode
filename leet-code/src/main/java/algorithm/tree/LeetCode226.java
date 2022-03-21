package algorithm.tree;

import javax.swing.tree.TreeNode;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/19
 */
public class LeetCode226 {
    /**
     * LeetCode 226 翻转二叉树
     * <p>
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
     *
     * @param root 二叉树的根节点
     * @return 翻转后的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    static class TreeNode {
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
