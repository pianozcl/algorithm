package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2020/9/28  2:08 PM
 * @description: 二叉树根节点到叶子节点的所有路径和
 **/
public class SumNumbers {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        System.out.println(sumNumbers(treeNode));
    }
    public static int sumNumbers (TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=0;
        return preOrder(root,sum);
    }

    private static int preOrder(TreeNode root,int sum){
        while (root==null){
            return 0;
        }
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        return preOrder(root.left,sum)+preOrder(root.right,sum);
    }
}
