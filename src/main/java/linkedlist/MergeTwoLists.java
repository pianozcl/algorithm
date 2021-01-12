package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  12:07 AM
 * @description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * {1,3,5},{2,4,6}
 *
 * {1,2,3,4,5,6}
 **/
public class MergeTwoLists {

    /**
     * 递归解法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 创建头节点解法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(9);
        listNode.next.next.next.next = new ListNode(10);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = new ListNode(7);
        listNode2.next.next.next.next = new ListNode(11);

        Merge2(listNode, listNode2);

    }
}
