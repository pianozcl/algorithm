package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/2/1  10:59 PM
 * @description: 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 **/
public class LowestCommonAncestorNocoder {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return root.val;
    }
}
