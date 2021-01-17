package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/13  11:53 PM
 * @description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 **/
public class KthNode {

    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null) {
            return null;
        }
        TreeNode left = KthNode(pRoot.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return pRoot;
        }
        TreeNode right = KthNode(pRoot.right, k);
        if (right != null) {
            return right;
        }
        return null;
    }
}
