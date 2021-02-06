package linkedlist;

import basestructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author : chenliangzhou
 * create at:  2021/2/6  9:32 PM
 * @description:
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
