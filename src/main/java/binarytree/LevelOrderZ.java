package binarytree;

import basestructure.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/13  11:24 AM
 * @description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 **/
public class LevelOrderZ {

    /**
     * DFS
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        recursion(list, pRoot, 0);
        for (int i = 0; i < list.size(); i++) {
            if ((i & 1) != 0) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    void recursion(ArrayList<ArrayList<Integer> > list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() - 1 < level) {
            ArrayList<Integer> subList = new ArrayList<>();
            list.add(subList);
            list.get(level).add(root.val);

        } else {
            list.get(level).add(root.val);
        }
        recursion(list, root.left, level + 1);
        recursion(list, root.right, level + 1);
    }


    /**
     * 双端队列
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            LinkedList<Integer> subQueue = new LinkedList();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if ((list.size() & 1) != 0) {
                    subQueue.addFirst(node.val);
                } else {
                    subQueue.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ArrayList<Integer> arrayList = new ArrayList(subQueue);
            list.add(arrayList);
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

        ArrayList<ArrayList<Integer>> arrayLists = new LevelOrderZ().Print(treeNode);
        System.out.println(JSON.toJSONString(arrayLists));
    }
}
