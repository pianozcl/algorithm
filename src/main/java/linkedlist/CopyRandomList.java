package linkedlist;

import basestructure.RandomListNode;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/1/12  11:07 AM
 * @description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 **/
public class CopyRandomList {

    /**
     * 利用hashmap保存新旧链表的结点映射关系，key保存旧链表，value保存新链表
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = pHead;
        while (curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = pHead;

        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(pHead);
    }
}
