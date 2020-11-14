package basestructure;

/**
 * @author : chenliangzhou
 * create at:  2020/9/28  12:51 PM
 * @description:
 **/
public class ListNode {
    int val;
    public ListNode next=null;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        ListNode listNode=this;
        while (listNode!=null){
            stringBuffer.append(listNode.val);
            stringBuffer.append("-->");
            listNode=listNode.next;
        }
        return stringBuffer.toString();
    }
}
