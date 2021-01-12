package basestructure;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  11:07 AM
 * @description: 复杂链表，每个结点包含next指针，和一个指向当前链表某个结点或者null到随机指针
 **/
public class RandomListNode {
    public int label;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int label) {
        this.label = label;
    }
}
