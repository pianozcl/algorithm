package binarytree;

import basestructure.TreeNode;

import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/7/23  12:29 AM
 * @description: 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 **/
public class FlattenTreeToSingleList {


    /**
     * 先序遍历的过程中，如果直接改变right指针指向，会丢失右节点记录。因此通过额外栈记录右节点
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = pop;
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            pre = pop;
        }
    }
}
