package binarytree;

import basestructure.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @author : chenliangzhou
 * create at:  2021/7/13  10:03 AM
 * @description: NC8 二叉树根节点到叶子节点和为指定值的路径
 * <p>
 * 描述
 * 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 **/
public class PathSumSpecificValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
        ArrayList<ArrayList<Integer>> arrayLists = pathSum(root, 1);
        System.out.println(JSON.toJSONString(arrayLists));
    }


    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        ArrayList<Integer> path = new ArrayList();
        addPath(root, path, list, sum);
        return list;
    }

    public static void addPath(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> list, int sum) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null && sum - root.val == 0) {
                //***注意这里要用new创建新的arraylist，因为直接传引用，最后一刚remove操作导致结果不对
                list.add(new ArrayList<>(path));
            } else {
                addPath(root.left, path, list, sum - root.val);
                addPath(root.right, path, list, sum - root.val);
            }
            //回溯
            path.remove(path.size() - 1);
        }
    }
}
