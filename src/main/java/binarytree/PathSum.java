package binarytree;

import basestructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/13  8:02 PM
 * @description: 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 **/
public class PathSum {
    ArrayList<ArrayList<Integer>> list = new ArrayList();
    LinkedList<Integer> link = new LinkedList();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        recur(root, target);
        return list;
    }

    void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        link.add(root.val);
        if (root.left == null && root.right == null && target == 0) {
            ArrayList<Integer> subList = new ArrayList(link);
            list.add(subList);
        }
        recur(root.left,target);
        recur(root.right,target);

        //回溯的时候移除叶子节点
        link.removeLast();
    }
}
