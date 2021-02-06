package binarytree;

import basestructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/2/5  9:31 PM
 * @description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 **/
public class AllBinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        recur(root, list, "");
        return list;
    }

    void recur(TreeNode root, List<String> list, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(path.concat(String.valueOf(root.val)));
            return;
        }
        recur(root.left, list, path.concat(String.valueOf(root.val)).concat("->"));
        recur(root.right, list, path.concat(String.valueOf(root.val)).concat("->"));
    }
}
