package com.run.simple.string;

/**
 * @Description: leetCode String 简单问题
 * @Author: linmeng
 * @CreateDate: 2019/5/18 21:06
 * @UpdateUser: linmeng
 * @UpdateDate: 2019/5/18 21:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class String1 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("abcde".indexOf("abcd"));

        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z
     *
     * @Description: 最长公共前缀
     * @Param strs 传入的字符串数组
     * @Return String 最长公共前缀
     * @Author: linmeng
     * @CreateDate: 2019/5/18 21:28
     * @UpdateUser: linmeng
     * @UpdateDate: 2019/5/18 21:28
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 两个循环获取多个字符串前缀 ，复杂度过高
     *
     * @param strs 字符串数组
     * @return String 前缀
     * @throws
     * @author 作者姓名
     * @date 2019/5/18 22:23
     */
    public static String longestCommonPrefix1(String[] strs) {
        String res = "abc";
        char re;
        // 数组长度
        int length = strs.length;
        // 直接一个循环 i 数组中字符串的元素，j代表 数组
        a:
        for (int i = 0; ; i++) {
            re = strs[0].charAt(i);
            // 判断字符串长度大于等于size
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i) {
                    break a;
                }
                if (re != strs[j].charAt(i)) {
                    break a;
                }
            }
            res = res + re;
        }
        return res;
    }

    /**
     * TODO 没有思路
     * 方法实现说明罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     * <p>
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     * <p>
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param s 传入罗马数字字符串
     * @return
     * @throws
     * @author linmeng
     * @date 2019/5/18 21:08
     */
    public int romanToInt(String s) {


        return 0;
    }
}
