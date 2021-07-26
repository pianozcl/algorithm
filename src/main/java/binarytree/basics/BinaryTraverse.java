package binarytree.basics;

import basestructure.TreeNode;
import util.test.TestStructure;

import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/2/16  5:29 PM
 * @description: 二叉树遍历
 **/
public class BinaryTraverse {
    public static void main(String[] args) {
        BinaryTraverse binaryTraverse = new BinaryTraverse();

        binaryTraverse.postOrderUnRecur(TestStructure.fullBinaryTree());
    }

    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    void preOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    void inOrderUnRecur(TreeNode root) {
        TreeNode head = root;
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val);
                    head = head.right;
                }
            }
        }
    }

    /**
     * 后续遍历
     * 因为先序遍历的顺序是中左右，所以需要一个栈先弹出中，再压右，再压左
     *
     * 而后续遍历的顺序是，左右中，所以第一个栈可以先以先弹出中，再压左，再压右。这样第一个栈弹出的顺序是：中》右》左
     * 第一个栈弹出的时候，直接压人第二个栈。这样第二个栈再弹出的时候顺序就是：左》右》中
     *
     * @param root
     */
    void postOrderUnRecur(TreeNode root) {
        TreeNode head = root;
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().val);
            }
        }

    }
}
