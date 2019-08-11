package com.run.simple.array.secondary;

import java.util.*;

/**
* @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *              给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
* @Author:         linmeng
* @CreateDate:     2019/8/4 15:17
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/4 15:17
* @Version:        1.0

*/
public class LeetCode17 {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("");
        System.out.println(strings);

    }

    /**
     * 数字同 字母对应
     */
    static Map<String,String> map = new HashMap<String, String>(){
        {
            put("2","abc");
            put("3","def");
            put("4","ghi");
            put("5","jkl");
            put("6","mno");
            put("7","pqrs");
            put("8","tuv");
            put("9","wxyz");

        }
    };

    /** 返回数据
     *
     */
    static List<String> res = new ArrayList<>();

    public static void backTrack(String combination, String next_digits){
        if (next_digits.length()==0){
            res.add(combination);
        }else{
            String digit = next_digits.substring(0,1);
            String letters = map.get(digit);
            for (int i=0;i<letters.length();i++){
                String letter = map.get(digit).substring(i,i+1);

                backTrack(combination+letter,next_digits.substring(1));
            }
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length()!=0){
            backTrack("",digits);
        }
        return res;
    }
}
