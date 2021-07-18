package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/3/10  8:38 PM
 * @description: 两链表相加，生成一个新的链表
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 **/
public class AddTwoNumbersList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int add = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null || add != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int res = a + b + add;
            curr.next = new ListNode(res % 10);
            curr = curr.next;
            add = res / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
