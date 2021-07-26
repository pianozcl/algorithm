package other;

import basestructure.ListNode;
import basestructure.TreeNode;
import binarytree.LevelOrder;
import com.alibaba.fastjson.JSON;
import sun.jvm.hotspot.debugger.Page;
import util.test.TestStructure;

import java.beans.IntrospectionException;
import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class OtherTest {
    public static void main(String[] args) {
        TreeNode treeNode = TestStructure.fullBinaryTree();
        post(treeNode);

    }

    public static void post(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);
            if (pop.left != null) {
                s1.push(pop.left);
            }
            if (pop.right != null) {
                s1.push(pop.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val);
        }
    }
}