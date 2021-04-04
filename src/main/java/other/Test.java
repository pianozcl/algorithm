package other;

import basestructure.TreeLinkNode;
import basestructure.TreeNode;
import util.test.TestStructure;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(0);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(1);
        treeNode1.left.left = new TreeNode(3);


    }


//    int count = 0;
//    public TreeNode kth(TreeNode treeNode, int k) {
//        if (treeNode == null) {
//            return null;
//        }
//        TreeNode l = kth(treeNode.left, k);
//        if (l != null) {
//            return l;
//        }
//        count++;
//        if (count == k) {
//            return treeNode;
//        }
//
//        kth(treeNode)
//    }

}
