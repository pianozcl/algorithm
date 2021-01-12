package binarytree;

import basestructure.TreeLinkNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  2:40 PM
 * @description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 **/
public class GetNext {
    /**
     * 根据中序遍历的顺序，分为以下情况
     *
     * 当前节点包含右子树，直接找到右子树的最左叶子返回
     * 当前节点不包含右子树，通过指向父节点的next指针，向上查找，如果next的left = 它自己，说明当前这个节点为next的左节点。中序的下一个节点即为next。
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
