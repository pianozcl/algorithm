package other.core_java.test_api;

import stackqueue.basic.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  4:37 PM
 * @description:
 **/
public class TestArrayDeque {
    public static void main(String[] args) {

        //ArrayDeque比linkedlist性能更好
        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        queue.addLast(1);
//        queue.addLast(2);
//        queue.addLast(3);
//
//        queue.removeLast();
//
//        for (Integer integer : queue) {
//            System.out.println(integer);
//        }

        LinkedList<Integer> link = new LinkedList<>();
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.removeLast();
        for (Integer integer : link) {
            System.out.println(integer);
        }
    }
}
