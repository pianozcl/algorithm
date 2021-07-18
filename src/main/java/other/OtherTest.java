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
        List<List<Integer>> lists = levelOrder(treeNode);
        for (int i = 0; i < lists.size(); i++) {
            if ((i & 1) == 0) {
                Collections.reverse(lists.get(i));
            }
        }

        System.out.println(JSON.toJSONString(lists));

    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                sub.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            list.add(sub);
        }
        return list;
    }
}
