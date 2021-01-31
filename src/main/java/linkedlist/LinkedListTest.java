package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/30  1:45 PM
 * @description: 测试模版
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);


    }
}
