package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2020/9/28  1:07 PM
 * @description:
 **/
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        System.out.println(listNode);

        System.out.println(reverseList(listNode));
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;

        //保存当前结点的next结点，再改变当前结点的next指向pre
        ListNode curr=head;
        while (curr!=null){
            curr=head.next;
            head.next=pre;
            pre=head;
            head=curr;
        }
        return pre;
    }
}
