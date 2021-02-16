package linkedlist;

import basestructure.ListNode;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/1/11  11:19 PM
 * @description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 **/
public class EntryNodeOfLoop {

    /**
     * HashMap法
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        HashMap<ListNode, ListNode> map = new HashMap();
        while (pHead != null) {
            if (map.containsKey(pHead)) {
                return pHead;
            }
            map.put(pHead, null);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 双指针解法，快指针每次走两步，慢指针每次走一步，如果相交说明必有环
     *
     * 相交之后，使其中一个指针重新指向头，一个指针保持原位置。两个指针每次均走一步，到第二次相交位置即是环到入口点
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop2(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = pHead;
                break;
            }
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
