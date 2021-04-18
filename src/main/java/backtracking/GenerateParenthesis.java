package backtracking;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/13  4:35 P
 * @description: 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 **/
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0){
            return list;
        }
        getParenthesis("", n, n, list);
        return list;
    }

    //left right从最大开始
    private void getParenthesis(String str,int left, int right, List<String> res) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        //左大于右，说明右括号多于左括号，不符合条件，直接返回
        if (left > right) {
            return;
        }

        //递归的拼接字符串
        if (left > 0) {
            getParenthesis(str + "(", left - 1, right, res);
        }
        if (right > 0) {
            getParenthesis(str + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(JSON.toJSONString(list));
    }
}
