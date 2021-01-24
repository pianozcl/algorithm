package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/1/22  11:28 PM
 * @description: LRU缓存算法
 **/
class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {

        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        //key存在，移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            //key不存在，创建新到节点，添加到map和链表头部
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;

            //如果超出容量，删除尾节点（最长时间没使用的元素）
            if (size > capacity) {
                DLinkedNode res = removeTail();
                map.remove(res.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    public void addToHead(DLinkedNode node) {
        //改变当前节点的前后指针
        node.prev = head;
        node.next = head.next;

        //改变旧的第一个节点的前指针指向，和头节点后指针指向
        head.next.prev = node;
        head.next = node;
    }


    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        res.prev.next = tail;
        tail.prev = res.prev;
        return res;
    }
}
