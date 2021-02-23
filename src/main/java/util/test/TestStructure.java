package util.test;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/2/16  6:45 PM
 * @description: 用于生成测试算法数据结构的工具类
 **/
public class TestStructure {

    public static TreeNode fullBinaryTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        return treeNode;
    }
}
