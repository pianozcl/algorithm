package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2020/9/30  3:43 PM
 * @description: 求二叉树的最小深度
 **/
public class MinDepth {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
//        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
//        treeNode.left.left=new TreeNode(4);
//        treeNode.left.right=new TreeNode(5);
//        treeNode.right.left=new TreeNode(6);
//        treeNode.right.right=new TreeNode(7);
        System.out.println(run(treeNode));
    }


    /**
     *  当前树的最小深度，可以看做是左右子树最小深度+1。递归求解
     */
    public static int run (TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int min=Integer.MAX_VALUE;
        if(root.left!=null){
            min=Math.min(run(root.left),min);
        }
        if(root.right!=null){
            min=Math.min(run(root.right),min);
        }
        return min+1;
    }

}
