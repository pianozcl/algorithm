package binarytree;

import basestructure.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  10:33 PM
 * @description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * {8,6,10,5,7,9,11}
 *
 * [[8],[6,10],[5,7,9,11]]
 **/
public class LevelOrder {

    /**
     * DFS  深度优先遍历
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        recur(list, pRoot, 0);
        return list;
    }

    void recur(ArrayList<ArrayList<Integer> > list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level < list.size()) {
            list.get(level).add(root.val);
        } else {
            ArrayList<Integer> subList = new ArrayList<>();
            list.add(subList);
            list.get(level).add(root.val);
        }
        recur(list, root.left, level + 1);
        recur(list, root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> sub = new ArrayList();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                sub.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sub);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        ArrayList<ArrayList<Integer>> print = new LevelOrder().Print(treeNode);
        System.out.println(JSON.toJSONString(print));
    }
}
