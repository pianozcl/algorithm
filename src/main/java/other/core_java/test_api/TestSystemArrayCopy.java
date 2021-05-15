package other.core_java.test_api;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/5/15  11:42 AM
 * @description: mative方法，拷贝数组方法
 **/
public class TestSystemArrayCopy {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7,9};

        /**
         * 原数组
         * 原数组下标（从哪开始拷贝）
         * 目标数组
         * 目标数组下标（从哪开始拷贝）
         * 拷贝的元素个数（需要注意原数组开始下标，避免数组越界）
         */
        System.arraycopy(arr, 3, arr, 2, 2);    //从第三个元素，后两个元素向前移动一位 [1,3,6,7,7,9]
        System.out.println(JSON.toJSONString(arr));
    }
}
