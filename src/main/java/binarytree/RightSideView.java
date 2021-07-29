package binarytree;

import basestructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/7/27  3:19 PM
 * @description: 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 * 示例 1:
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 *
 * 输入: []
 * 输出: []
 *
 **/
public class RightSideView {
    /**
     * 层序遍历获取每一层的最后一个元素
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        LinkedList<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {

            //curr记录每一层的最后一个元素
            TreeNode curr = null;
            for (int i = queue.size(); i > 0; i--) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            list.add(curr.val);
        }
        return list;
    }
}
