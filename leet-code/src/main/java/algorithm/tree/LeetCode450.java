package algorithm.tree;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/21
 */
public class LeetCode450 {
    /**
     * LeetCode 450 删除二叉搜索树中的节点
     * <p>
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。
     * 返回二叉搜索树（有可能被更新）的根节点的引用。
     * <p>
     * 一般来说，删除节点可分为两个步骤：
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     *
     * @param root 二叉树的根节点
     * @param key  需要被删除的数据
     * @return 删除key对应的节点后，二叉树的根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 只有右孩子，返回右孩子
            if (root.left == null) {
                return root.right;
            }
            // 只有左孩子，返回左孩子
            if (root.right == null) {
                return root.left;
            }
            // 找到右子树中最小的节点，用来替换父节点
            TreeNode min = getMin(root.right);
            // 删除右子树中最小的节点
            root.right = deleteNode(root.right, min.val);
            // 用右子树最小节点替换root节点
            min.left = root.left;
            min.right = root.right;
            root = min;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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
