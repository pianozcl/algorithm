package binarytree;

import basestructure.TreeNode;
import util.test.TestStructure;

/**
 * @author : chenliangzhou
 * create at:  2021/3/4  1:20 AM
 * @description: 给定一棵完全二叉树的头节点head，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 **/
public class CompleteBinaryTreeNodeCount {
    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int level = 0;
        while (head != null) {
            head = head.left;
            level++;
        }
        int count = 0;
        for (int i = 0; i < level; i++) {
            count += Math.pow(2, i);
        }
        return count;
    }

    //TODO
    public static void main(String[] args) {
        TreeNode treeNode = TestStructure.fullBinaryTree();
        int i = new CompleteBinaryTreeNodeCount().nodeNum(treeNode);
        System.out.println(i);
    }
}
