package basestructure;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  2:41 PM
 * @description: 包含指向父节点指针的node
 **/
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
