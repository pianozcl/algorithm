package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/1/11  11:00 PM
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 **/
public class FindKthToTail {

    /**
     * 双指针解法，前指针先走k步，然后两个指针一起走，直到前指针为null，后指针所在的位置即倒数第k个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) {
            if (former == null) {
                return null;
            }
            former = former.next;
        }

        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
