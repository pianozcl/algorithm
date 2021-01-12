package linkedlist;

import basestructure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/11  1:29 PM
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 **/
public class ReversePrint {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursion(listNode);
        return list;
    }

    /**
     * 递归回溯。当结点为null时开始回溯，一层一层返回，利用这个返回过程，添加元素到list
     * @param listNode
     */
    void recursion(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        recursion(listNode.next);
        list.add(listNode.val);
    }


    /**
     * 方法2，用LinkedList栈，正序压栈，出栈刚好是倒序
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        LinkedList<Integer> list = new LinkedList<>();
        while (listNode != null) {
            list.addFirst(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.removeFirst());
        }
        return arrayList;
    }
}
