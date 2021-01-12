package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  4:15 PM
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 **/
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //我们约定空树不是任意一个树的子结构
        if (root1 == null || root2 == null) {
            return false;
        }
        return recur(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 比较root1，root2是否相同
     * @param root1
     * @param root2
     * @return
     */
    boolean recur(TreeNode root1, TreeNode root2) {
        //root2直到为null，说明当前递归链路没有不想的情况，结合最后一行与运算，意味着所有的链路都一样整体才会返回true
        if (root2 == null) {
            return true;
        }
        //如果有不想等的情况直接返回false。
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        //递归的比较子树是否相同
        return recur(root1.left, root2.left) && recur(root1.right, root2.right);
    }
}
