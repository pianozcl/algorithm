package linkedlist;

import basestructure.ListNode;

/**
 * @author : chenliangzhou
 * create at:  2021/8/4  3:32 PM
 * @description: 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 **/
public class RemoveNthFromEnd {

    /**
     * 双指针
     * 前指针走n步，然后后指针一起走。（前后指针距离始终为n）前指针走到末尾，后指针位置即为倒数n节点
     *
     * 优化点：创建虚拟头节点，慢指针指向位置最终为倒数n + 1个节点。这样直接通过back.next = back.next.next，即可删除倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
