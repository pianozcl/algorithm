package binarytree;

import basestructure.TreeNode;

import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/1/13  4:42 PM
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 **/
public class VerifyPostorder {
    /**
     * 思路：例如后续遍历序列
     * 1，3，2，5，7，6，4
     * 4为root节点，又因为为搜索树，1，3，2小于4，为左子树序列。5，7，6大于4为右子树序列
     * 因此，通过判断左右子树对序列值，与根节点比较。例如 1，3，2小于4，5，7，6大于4，然后再对1，3，2和5，7，6进行递归求解
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return recur(sequence, 0, sequence.length - 1);
    }

    boolean recur(int[] sequence, int i, int j) {
        if(i >= j) {
            return true;
        }
        int p = i;
        //这里遍历过程中，已经相当于判断了左子树
        while (sequence[p] < sequence[j]) {
            p++;
        }
        int m = p;
        //判断右子树
        while (sequence[p] > sequence[j]) {
            p++;
        }
        // p == j,判断右子树对时候，右子树序列必须大于根节点，如果有一个值小于根节点，p就不等于j，就会返回false
        return (p == j) && recur(sequence, i, m - 1) && recur(sequence, m, j - 1);
    }


    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        int[] arr = {1,3,2,5,7,6,4};

        boolean b = new VerifyPostorder().verifyPostorder(arr);
        System.out.println(b);
    }

}
