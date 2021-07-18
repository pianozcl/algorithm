package string;

import java.util.PriorityQueue;

/**
 * @author : chenliangzhou
 * create at:  2021/7/18  7:35 PM
 * @description: 767. 重构字符串
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 **/
public class ReorganizeString {

    public static void main(String[] args) {
        reorganizeString("bfrbs");
    }
    public static String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }

        //第一步，现将s中出现的字符次数分别记录下来（用大小为26的数组记录）
        //同时记录出现次数最大的，用于判断是否符合条件
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        //当max > length - max + 1的时候，不符合条件直接返回""
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        /**
         * 无论数组是奇数还是偶数位，偶数下标个数总是>=奇数。所以偶数下标用于存放max。例如此时max = len / 2 + 1
         *
         * 创建一个跟s长度相同的char数组，先存放奇数位，
         */
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
                while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            //临界情况，count[i]大于一半的个数，需要存放偶数位。或者是奇数位已经用完了odd >= length，也需要存放偶数位
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }

    /**
     * 1. 采用大顶堆的方式（堆保存字符，并按字符出现次数排序）。
     * 2. 每次弹出两个元素（出现次数最多的两个），并添加到buffer。同时这两个元素出现次数减1
     * 3. 如果弹出的字符，出现次数-1之后还是>0，重新添加到堆
     * @param s
     * @return
     */
    public static String reorganizeStringMaxHeap(String s) {
        if (s.length() < 2) {
            return s;
        }

        //第一步，现将s中出现的字符次数分别记录下来（用大小为26的数组记录）
        //同时记录出现次数最大的，用于判断是否符合条件
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        //当max > length - max + 1的时候，不符合条件直接返回""
        if (maxCount > (length + 1) / 2) {
            return "";
        }


        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> counts[c2 - 'a'] - counts[c1 - 'a']);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                queue.offer((char)('a' + i));
            }
        }

        while (queue.size() > 1) {
            Character c1 = queue.poll();
            Character c2 = queue.poll();
            buffer.append(c1);
            buffer.append(c2);
            counts[c1 - 'a']--;
            counts[c2 - 'a']--;
            if (counts[c1 - 'a'] != 0) {
                queue.offer(c1);
            }
            if (counts[c2 - 'a'] != 0) {
                queue.offer(c2);
            }
        }
        if (queue.size() > 0) {
            buffer.append(queue.poll());
        }

        return buffer.toString();
    }
}
