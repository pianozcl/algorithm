package binarytree;

import basestructure.TreeNode;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/1/13  8:41 PM
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 **/
public class TreeToDoubleList {
    int i = 0;
    public TreeNode Convert(TreeNode pRootOfTree) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        inOrder(pRootOfTree, map);
        for (int j = 0; j < map.size(); j++) {
            map.get(j).right = map.get(j + 1);
        }
        for (int j = map.size() - 1; j >= 0; j--) {
            map.get(j).left = map.get(j - 1);
        }
        return map.get(0);
    }

    void inOrder(TreeNode root, HashMap<Integer, TreeNode> map) {
        if (root == null) {
            return;
        }
        inOrder(root.left, map);
        map.put(i++, root);
        inOrder(root.right, map);
    }


    /**
     * 紧跟curr后面的pre指针，和始终指向中序遍历第一个节点的head指针，中序遍历过程中，改变指针的指向，最后返回head即可
     */
    TreeNode pre, head;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        TreeNode curr = pRootOfTree;
        inOrder(pRootOfTree);
        return head;
    }

    /**
     *
     * @param curr
     */
    void inOrder(TreeNode curr) {
        if (curr == null) {
            return;
        }
        inOrder(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        inOrder(curr.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        TreeToDoubleList treeToDoubleList = new TreeToDoubleList();
        TreeNode convert = treeToDoubleList.Convert(treeNode);
    }
}
