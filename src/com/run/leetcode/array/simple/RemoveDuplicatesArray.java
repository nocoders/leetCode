package com.run.leetcode.array.simple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: linmeng
 * @CreateDate: 2019/5/25 16:49
 * @UpdateUser: linmeng
 * @UpdateDate: 2019/5/25 16:49
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class RemoveDuplicatesArray {

    public static void main(String[] args) {

    }

    /**@TODO 未完成
     * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
     * 返回车能够在一次移动中捕获到的卒的数量。
     * 方法实现说明：白色的车遇到白色的象就跳过循环
     *
     * @param board 二维数组
     * @return
     * @throws
     * @author linmeng
     * @date 2019/6/16 21:42
     */
    public int numRookCaptures(char[][] board) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, result = 0;
        // 获取车的所在位置
        be:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    a = i;
                    b = j;
                    break be;
                }
            }
        }

        if (a == b && a == Integer.MAX_VALUE) {
            return result;
        }
        // 判断左下的可捕获数量
        for (int i = a; i >= 0; i--) {

        }
        return 9;
    }

    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * 你可以按任意顺序返回答案。
     * 方法实现说明 首先，将第一个字符串中的字符 各个字母出现次数 作为值存入 另一个数组中（该数组以0-25)为下标
     * 然后再使用一个临时数组，存入其他 字符串中各个字母的长度，最后取最小的数据放入上面的数组中
     *
     * @param A 字符串数组
     * @return
     * @throws
     * @author linmeng
     * @date 2019/6/9 18:50
     */
    public static List<String> commonChars(String[] A) {
        int[] res = new int[26];
        if (A.length <= 0) {
            return null;
        }
        for (char a : A[0].toCharArray()) {
            res[a - 97]++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] tmp = new int[26];
            for (char a : A[i].toCharArray()) {
                tmp[a - 97]++;
            }
            for (int j = 0; j < tmp.length; j++) {
                res[j] = (res[j] > tmp[j]) ? tmp[j] : res[j];
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                result.add(String.valueOf((char) (i + 97)));
            }
        }
        return result;
    }

    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
     * 方法实现说明:将数组 对 60求余  ,求余 为  0 和 30的 为一种，其他1-29位一种
     *
     * @param time
     * @return
     * @throws
     * @author linmeng
     * @date 2019/6/7 15:01
     */
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        //2.方法二：创建一个包含六十个元素的数组，将模60的结果存入
        int temp[] = new int[60];
        for (int i = 0; i < time.length; i++) {
            temp[time[i] % 60]++;
        }
        // 获取 求余为 0.和30 的数量
        count = count + temp[0] * (temp[0] - 1) / 2 + temp[30] * (temp[30] - 1) / 2;
        // 因为 求 两数和为60  的只需要求 1-29的，不需要求两遍
        for (int i = 1; i < 30; i++) {
            count = count + temp[i] * temp[60 - i];
        }

        return count;
    }

    /**
     * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     * 方法实现说明:求和，求是否有平均数，有就去获取第一个小数组，在获取第二个第三个
     *
     * @param A
     * @return
     * @throws
     * @author 作者姓名
     * @date 2019/6/7 11:04
     */
    public boolean canThreePartsEqualSum(int[] A) {
        //  数组求和
        int sum = 0, avg = 0;
        for (int i : A) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return false;
        }
        avg = sum / 3;
        sum = 0;
        for (int i = 0, j = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (avg == sum) {
                j++;
                sum = 0;
                if (j == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票
     * 方法实现说明:遍历数组，先判断最小值，再判断数组同最小值差是否大于最大值。
     *
     * @param prices
     * @return
     * @throws
     * @author 作者姓名
     * @date 2019/6/7 21:04
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;
    }

    /**
     * 获取杨辉三角的第rowIndex层
     * 方法实现说明：
     *
     * @param null
     * @return
     * @throws
     * @TODO 搞不懂
     * @author 作者姓名
     * @date 2019/6/7 16:31
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        if (rowIndex == 0) {
            return list;
        }
        // 将第一行添加进去
        list.add(1);

        for (int i = 1; i < rowIndex; i++) {

        }
        return null;
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * @param numRows 杨辉三角的边长
     * @return
     * @throws
     * @author 作者姓名
     * @date 2019/5/30 22:38
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        // 判断 numRows是否为0
        if (numRows == 0) {
            return lists;
        }
        List<Integer> a = new ArrayList<>();
        a.add(1);

        // 第一行数据一直为1
        lists.add(a);

        for (int i = 1; i < numRows; i++) {
            // 第i行的 数据
            List<Integer> list = new ArrayList<>();
            List<Integer> provList = lists.get(i - 1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(provList.get(j - 1) + provList.get(j));
            }
            list.add(1);

            lists.add(list);
        }

        return lists;
    }


    /**
     * 方法实现说明：数组从索引0开始，在后面添加数字，相当于之前的数字乘2再加
     *
     * @param A 二进制 数组
     * @return
     * @throws
     * @author linmeng
     * @date 2019/6/7 10:35
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>(A.length);
        int res = 0;
        for (int i : A) {
            res = (res << 1) % 5 + (i == 1 ? 1 : 0);
            list.add(res % 5 == 0);
        }

        return list;
    }

    /**
     * 获取将无序数组转换为有序数组的必要移动数据个数
     * 先获取有序数组，然后循环判断两个数组的数据不同的地方
     *
     * @param heights 无序数组
     * @return
     * @throws
     * @author linmeng
     * @date 2019/6/1 21:20
     */
    public static int heightChecker(int[] heights) {
        int[] tmp = heights.clone();

        Arrays.sort(tmp);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != tmp[i]) {
                res++;
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @Author: linmeng
     * @CreateDate: 2019/5/27 22:35
     * @UpdateUser: linmeng
     * @UpdateDate: 2019/5/27 22:35
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 合并两个有序数组
     *
     * @author 林猛
     * @date 2019/5/27 20:31
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }

    /**
     * 整数加一
     *
     * @param digits 整数数组
     * @return int[]
     * @author linmeng
     * @date 2019/5/26 22:48
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    /**
     * 求数组最大子序和:1:暴力求和，定义i,然后i内循环到length，再到里面的的j
     *
     * @param nums 无序数组
     * @return
     * @throws
     * @author 作者姓名
     * @date 2019/5/26 21:31
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            if (res < sum) {
                res = sum;
            }
        }
        return res;
    }

    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int k = i; k < nums.length; k++) {
                sum += nums[k];
                res = (res < sum ? sum : res);
            }
        }
        return res;
    }

    public static int maxSubArray1(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int k = i; k < nums.length; k++) {
                int sum = 0;
                for (int j = i; j <= k; j++) {
                    sum += nums[j];
                }
                res = (sum > res ? sum : res);
            }
        }
        return res;
    }

    /**
     * 去除重复数据
     *
     * @param nums
     * @return
     * @throws
     * @author linmeng
     * @date 2019/5/25 16:50
     */
    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素
     *
     * @param nums 整形数组
     * @return int 元素插入位置
     * @throws
     * @author linmeng
     * @Param target 插入元素
     * @date 2019/5/25 23:06
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            } else {
                if (nums.length <= i + 1) {
                    return i + 1;
                } else {
                    if (target <= nums[i + 1]) {
                        return i + 1;
                    } else {
                        i++;
                    }
                }

            }
        }
        return nums.length;
    }
}
