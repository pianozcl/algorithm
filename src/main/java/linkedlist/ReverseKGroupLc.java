package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/7/17  11:55 PM
 * @description: 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 **/
public class ReverseKGroupLc {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            //tail记录每一组的结尾
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;

                //当剩余节点不满k个直接返回
                if (tail == null) {
                    return dummy.next;
                }
            }

            //局部反转。此时局部反转返回的arr[0]代表新的头部
            ListNode[] arr = reverse(head, tail);
            head = arr[0];
            tail = arr[1];

            //pre要重新调整指向新的头部
            pre.next = head;
            //更新pre为下一组的pre
            pre = tail;
            //更新head为下一组的head
            head = tail.next;
            //tail下一轮循环开始就应该是等于pre，所以不需要更新
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
