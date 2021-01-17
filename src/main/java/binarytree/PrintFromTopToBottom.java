package binarytree;

import basestructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  10:01 PM
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 **/
public class PrintFromTopToBottom {

    /**
     * 队列辅助，利用队列先进先出的特性
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
