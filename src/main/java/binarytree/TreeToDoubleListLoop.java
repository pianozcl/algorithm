package binarytree;

import basestructure.Node;

import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/7/23  1:40 AM
 * @description: 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 最后将链表头尾相连，形成一个环
 **/
public class TreeToDoubleListLoop {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrder(Node curr) {
        if (curr == null) {
            return;
        }
        inOrder(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        inOrder(curr.right);
    }

    /**
     * 非递归版，中序遍历的过程中，转换
     * @param root
     */
    public void inOrderIterater(Node root) {
        Node curr = root;
        if (curr == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (pre == null) {
                    head = curr;
                } else {
                    pre.right = curr;
                }
                curr.left = pre;
                pre = curr;
                curr = curr.right;
            }
        }
    }
}
