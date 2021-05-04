package binarytree.multiwaytree.basics;

import basestructure.MultiTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/20  12:17 AM
 * @description: 非递归遍历n叉树
 **/
public class TraverseMultiTree {

    public static void preorder(MultiTreeNode root) {
        LinkedList<MultiTreeNode> stack = new LinkedList<>();
        if (root == null) {
            return;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            MultiTreeNode node = stack.pollLast();
            System.out.println(node.val);

            if (node.childrens == null) {
                continue;
            }
            Collections.reverse(node.childrens);
            for (MultiTreeNode children : node.childrens) {
                stack.add(children);
            }
        }
    }


    public static void main(String[] args) {
        MultiTreeNode multiTreeNode = new MultiTreeNode(0);
        List<MultiTreeNode> childrens = new ArrayList<>();
        MultiTreeNode multiTreeNode1 = new MultiTreeNode(1);
        MultiTreeNode multiTreeNode2 = new MultiTreeNode(2);
        MultiTreeNode multiTreeNode3 = new MultiTreeNode(3);
        childrens.add(multiTreeNode1);
        childrens.add(multiTreeNode2);
        childrens.add(multiTreeNode3);

        List<MultiTreeNode> childrens1 = new ArrayList<>();
        MultiTreeNode multiTreeNode4 = new MultiTreeNode(4);
        childrens1.add(multiTreeNode4);

        multiTreeNode1.setChildrens(childrens1);

        multiTreeNode.setChildrens(childrens);

        preorder(multiTreeNode);
    }
}
