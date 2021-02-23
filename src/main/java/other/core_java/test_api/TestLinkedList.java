package other.core_java.test_api;

import basestructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/2/22  12:43 PM
 * @description: 练习linkedlist api
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        List<Integer> list = new ArrayList<>(linkedList);



        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        System.out.println(queue.poll());
    }
}
