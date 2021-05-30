package linkedlist;

import basestructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/5/18  5:46 PM
 * @description: 160. 相交链表 编写一个程序，找到两个单链表相交的起始节点。
 **/
public class GetIntersectionNode {


    /**
     * 双指针解法。a走过的路+公共的路+b走过的路 = b走过的路 + 公共的路 + a走过的路
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Map<ListNode, ListNode> map = new HashMap();
        ListNode curr = headA;
        while (curr != null) {
            map.put(curr, null);
            curr = curr.next;
        }
        while (headB != null) {
            if (map.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
