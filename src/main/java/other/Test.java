package other;

import basestructure.ListNode;
import basestructure.TreeNode;
import binarytree.LevelOrder;
import com.alibaba.fastjson.JSON;
import sun.jvm.hotspot.debugger.Page;
import util.test.TestStructure;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(1);
        p.right = new TreeNode(2);

        //mirror(p);

        System.out.println(p.right.val);
    }

    public static void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            System.out.println();
        }
    }
}
