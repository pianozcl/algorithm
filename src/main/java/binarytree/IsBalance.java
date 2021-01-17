package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/14  10:18 AM
 * @description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 **/
public class IsBalance {

    /**
     * 剪枝，直接返回子树高度，或者-1，进而不需要重复计算子问题
     * @author zhouchenliang
     * @date 10:37 AM 2021/1/14
     * @param
     * @return
     * @throws
     **/
    public boolean IsBalanced_Solution(TreeNode root) {
        return recur(root) != -1;
    }

    int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;

    }

    /**
     * 暴力破解
     * @author zhouchenliang
     * @date 10:18 AM 2021/1/14
     * @param
     * @return
     * @throws
     **/
    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = treeDepth(root.left) - treeDepth(root.right);
        if (diff > 1 || diff < -1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    /**
     * 计算树深度
     * @param root
     * @return
     */
    int treeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}
