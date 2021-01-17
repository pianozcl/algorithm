package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/14  4:20 PM
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 **/
public class LowestCommonAncestor {
    /**
     * 后序遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root 为null或者p、q时返回root，递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //回溯的过程中，如果没找到p、或者q，会向上返回null，找到的话就会向上返回当前p，或者q的值
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //走到这说明左右子树都不为null，意味着p、q分别在当前root左右子树，因此root就是最近的公共祖先，直接返回root
        return  root;
    }
}
