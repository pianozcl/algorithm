package linkedlist;

import basestructure.ListNode;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  11:24 AM
 * @description: 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 **/
public class FindFirstCommonNode {

    /**
     * 利用HashMap，先遍历第一个链表，将每个结点存为key。再遍历第二个结点，如果map key等于当前结点，返回
     *
     * @param
     * @return
     * @throws
     * @author zhouchenliang
     * @date 11:25 AM 2021/1/12
     **/
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode, Integer> map = new HashMap();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            map.put(p1, null);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (map.containsKey(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }

    /**
     * p1 p2一起向前走，如果p1到终点，让p1指向head2。p2到终点，p2指向head1。这样第二次相遇，必定是交点，因为经过交换，两个指针走过到路程相同
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }


    public static void main(String[] args) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(1);
        ListNode node = FindFirstCommonNode(h1, h2);
        System.out.println(node.val);
    }
}
