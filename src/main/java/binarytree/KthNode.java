package binarytree;

import basestructure.TreeNode;
import com.alibaba.fastjson.JSON;

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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.left.left = new TreeNode(1);

        TreeNode treeNode1 = new KthNode().KthNode(treeNode, 3);
        System.out.println(treeNode1.val);
    }
}

//LC version
class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int left = kthSmallest(root.left, k);
        if (left != 0) {
            return left;
        }
        count++;
        if (count == k) {
            return root.val;
        }

        int right = kthSmallest(root.right, k);
        if (right != 0) {
            return right;
        }
        return 0;
    }
}
