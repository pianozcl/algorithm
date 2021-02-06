package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/2/6  10:41 PM
 * @description: 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少
 **/
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 思路，先计算叶子节点的最大贡献值，也就是它自己的val,自底向上计算非叶子节点最大贡献值。中间用pathSum计算经过当前节点的最大
     * 路径，因为当前节点可能为负，所以用maxSum记录
     * @param node
     * @return
     */
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int pathSum = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, pathSum);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
