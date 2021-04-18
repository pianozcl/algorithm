package linkedlist;

import basestructure.ListNode;
import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;

/**
 * @author : chenliangzhou
 * create at:  2021/4/14  3:42 PM
 * @description: 23. 合并K个升序链表 给你一个链表数组，每个链表都已经按升序排列。  请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue();     //小根堆

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.offer(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (queue.size() > 0) {
            head.next = new ListNode(queue.poll());
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);


        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] arr = new ListNode[]{n1, n2, n3};

        ListNode listNode = new MergeKLists().mergeKLists(arr);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
