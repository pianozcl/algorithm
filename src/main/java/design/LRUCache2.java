package design;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/1/30  6:08 PM
 * @description: 牛客版本
 **/
public class LRUCache2 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
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

    DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        res.prev.next = res.next;
        res.next.prev = res.prev;
        return res;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            map.put(key, newNode);
            size++;

            if (size > capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int[] LRU (int[][] operators, int k) {
        capacity = k;
        ArrayList<Integer> list = new ArrayList<>();
        // write code here
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                put(operator[1], operator[2]);
            }
            if (operator[0] == 2) {
                int i = get(operator[1]);
                list.add(i);
            }
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1}, {1,2,2}, {1,3,2}, {2,1}, {1,4,4}, {2,2}};
        int[] lru = new LRUCache2(0).LRU(arr, 3);
        System.out.println(JSON.toJSONString(lru));
    }


}
