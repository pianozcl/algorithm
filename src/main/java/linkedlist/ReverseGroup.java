package linkedlist;

import basestructure.ListNode;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * @author : chenliangzhou
 * create at:  2021/1/30  1:42 PM
 * @description: 给定的链表是
 * 1 2 3 4 5
 * K = 2
 * 2 1 4 3 5
 **/
public class ReverseGroup {




    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head, temp;
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }

        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                temp = curr.next;
                curr.next = temp.next;  //一轮循环完，curr.next刚好是下一组k的头
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        reverseKGroup(listNode, 2);
        System.out.println();

    }

}
