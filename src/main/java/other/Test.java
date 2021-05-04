package other;

import basestructure.ListNode;
import basestructure.TreeNode;
import binarytree.LevelOrder;
import com.alibaba.fastjson.JSON;
import sun.jvm.hotspot.debugger.Page;
import util.test.TestStructure;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
    }

    public int max(int[] arr) {
        int cost = 0x7fffffff;
        int profit = 0;
        for (int i = 0; i < arr.length; i++) {
            cost = Math.min(cost, arr[i]);
            profit = Math.max(profit, profit - cost);
        }
        return profit;
    }
}
