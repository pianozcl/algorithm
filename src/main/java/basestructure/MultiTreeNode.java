package basestructure;

import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/20  12:16 AM
 * @description: 多叉树
 **/
public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> childrens;

    public MultiTreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<MultiTreeNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<MultiTreeNode> childrens) {
        this.childrens = childrens;
    }
}
