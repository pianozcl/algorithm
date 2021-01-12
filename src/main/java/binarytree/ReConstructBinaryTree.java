package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  1:58 PM
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 **/
public class ReConstructBinaryTree {

    /**
     * 前序遍历的头结点为root结点，接着是左子树，右子树。
     * 找到中序序列的 前序头结点，可把中序列分为左右子树，进而计算出子树的坐标，递归的创建子
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return recursion(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode recursion(int[] pre, int startPre, int endPre, int in[], int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        //遍历中序序列，根据前序头（root）节点，划分左右子树
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = recursion(pre, startPre + 1 ,startPre + i - startIn, in, startIn, i - 1);
                root.right = recursion(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}
