package binarytree;

import basestructure.TreeNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  8:19 PM
 * @description: 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 **/
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return check(pRoot.left, pRoot.right);
    }

    boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
