package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/11  8:00 PM
 * @description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 **/
public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode curr = pHead;

        //创建一个新头结点，以处理前几个元素相同的情况，前几个元素如果相同，直接使新头结点指向首个不相同的链表节点
        //直接操作的相当与head
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr =curr.next;
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);


        System.out.println(listNode.toString());
        ListNode listNode1 = deleteDuplication(listNode);


        System.out.println(listNode1.toString());
    }
}
