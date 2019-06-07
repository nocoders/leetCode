package com.run.simple.array.simple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
* @Author:         linmeng
* @CreateDate:     2019/5/25 16:49
* @UpdateUser:     linmeng
* @UpdateDate:     2019/5/25 16:49
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class RemoveDuplicatesArray {

    public static void main(String[] args) {
        int a =Integer.MAX_VALUE;
        int [] aa={0,3,8,6,8,6,6,8,2,0,2,7};
        int i = maxProfit(aa);
        System.out.println(i);

    }

    /**在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
    * 方法实现说明:将数组 对 60求余  然后循环判断余数相加是否同60求余为0
    * @TODO 超时，题解看不懂
     * @author      linmeng
    * @param time
    * @return
    * @exception
    * @date        2019/6/7 15:01
    */
    public int numPairsDivisibleBy60(int[] time) {
        for (int i:time){
            i=i%60;
        }
        int res=0;
        for (int i=0;i< time.length;i++){
            for (int j=i+1;j<time.length;j++){
                if ((time[i]+time[j])%60==0){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
    * 方法实现说明:求和，求是否有平均数，有就去获取第一个小数组，在获取第二个第三个
    * @author      作者姓名
    * @param A
    * @return
    * @exception
    * @date        2019/6/7 11:04
    */
    public boolean canThreePartsEqualSum(int[] A) {
        //  数组求和
        int sum=0,avg=0;
        for (int i:A){sum+=i;}

        if (sum%3 !=0){return false;}
        avg =sum/3; sum=0;
        for (int i=0,j=0;i<A.length;i++){
            sum = sum+A[i];
            if (avg==sum){
                j++;sum=0;
                if (j==3){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     注意你不能在买入股票前卖出股票
    * 方法实现说明:遍历数组，先判断最小值，再判断数组同最小值差是否大于最大值。
    * @author      作者姓名
    * @param prices
    * @return      
    * @exception   
    * @date        2019/6/7 21:04
    */
    public static int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,max=0;
        for (int i=0;i<prices.length;i++){
            if (min>prices[i]){
                min=prices[i];
            }else if (prices[i]-min>max){
                max=prices[i]-min;
            }
        }

        return max;
    }

    /**
        获取杨辉三角的第rowIndex层
    * 方法实现说明：
     * @TODO 搞不懂
    * @author      作者姓名
    * @param null
    * @return
    * @exception
    * @date        2019/6/7 16:31
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer>list=new LinkedList<>();
        if (rowIndex==0){return list;}
        // 将第一行添加进去
        list.add(1);

        for (int i=1;i<rowIndex;i++){

        }
        return null;
    }

    /**
    
    * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    * @author      作者姓名
    * @param numRows 杨辉三角的边长
    * @return      
    * @exception   
    * @date        2019/5/30 22:38
    */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        // 判断 numRows是否为0
        if (numRows==0){return lists;}
        List<Integer> a=new ArrayList<>();
        a.add(1);

        // 第一行数据一直为1
        lists.add(a);

        for (int i=1;i<numRows;i++){
            // 第i行的 数据
            List<Integer> list= new ArrayList<>();
            List<Integer> provList=lists.get(i-1);
            list.add(1);
            for (int j=1;j<i;j++){
                list.add(provList.get(j-1)+provList.get(j));
            }
            list.add(1);

            lists.add(list);
        }

        return lists;
    }


    /**

    * 方法实现说明：数组从索引0开始，在后面添加数字，相当于之前的数字乘2再加
    * @author      linmeng
    * @param A 二进制 数组
    * @return
    * @exception
    * @date        2019/6/7 10:35
    */
    public List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> list = new ArrayList<>(A.length);
            int res=0;
            for(int i:A){
                res=(res<<1)%5+(i==1?1:0);
                list.add(res%5==0);
            }

            return list;
    }

    /**
    
    * 获取将无序数组转换为有序数组的必要移动数据个数
     *  先获取有序数组，然后循环判断两个数组的数据不同的地方
    * @author      linmeng
    * @param heights 无序数组
    * @return      
    * @exception   
    * @date        2019/6/1 21:20
    */
    public static int heightChecker(int[] heights) {
        int[] tmp = heights.clone();

        Arrays.sort(tmp);
        int res=0;
        for (int i=0;i<heights.length;i++){
            if (heights[i]!=tmp[i]){
                res++;
            }
        }
        return res;
    }
    
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
    * @Description: 给定两个二叉树，编写一个函数来检验它们是否相同。
     *               如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    * @Author:         linmeng
    * @CreateDate:     2019/5/27 22:35
    * @UpdateUser:     linmeng
    * @UpdateDate:     2019/5/27 22:35
    * @UpdateRemark:   修改内容

    * @Version:        1.0

    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p ==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        if ( p.val !=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    /**

    * 合并两个有序数组
    * @author      林猛
    * @date        2019/5/27 20:31
    */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int k = m+n-1,i=m-1,j=n-1;k>=0;k--){
            if (i<0){
                nums1[k]=nums2[j--];
                continue;
            }
            if (j<0){
                nums1[k]=nums1[i--];
                continue;
            }
            if (nums1[i]>=nums2[j]){
                nums1[k]=nums1[i--];
            }else {
                nums1[k]=nums2[j--];
            }
        }
    }

    /**

    * 整数加一
    * @author      linmeng
    * @param digits 整数数组
    * @return     int[]
    * @date        2019/5/26 22:48
    */
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]==9){
                digits[i]=0;
            }else {
                digits[i]++;
                return digits;
            }
        }
        int [] res =new int[digits.length+1];
        res[0]=1;
        return res;
    }
    /**

    * 求数组最大子序和:1:暴力求和，定义i,然后i内循环到length，再到里面的的j
    * @author      作者姓名
    * @param nums 无序数组
    * @return
    * @exception
    * @date        2019/5/26 21:31
    */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum=sum>0?sum+nums[i]:nums[i];
            if (res<sum){
                res=sum;
            }
        }
        return res;
    }
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int k=i;k<nums.length;k++){
                sum+=nums[k];
                res=(res<sum?sum:res);
            }
        }
        return res;
    }
    public static int maxSubArray1(int[] nums) {
        int res = nums[0];
        for (int i=0;i<nums.length;i++){
            for (int k=i;k<nums.length;k++){
                int sum=0;
                for (int j=i;j<=k;j++){
                    sum+=nums[j];
                }
                res=(sum>res?sum:res);
            }
        }
        return res;
    }
    /** 去除重复数据
    * @author      linmeng
    * @param nums
    * @return
    * @exception
    * @date        2019/5/25 16:50
    */
    public static int removeDuplicates(int[] nums) {

       int i=0;
       for (int j=1;j<nums.length;j++){
           if (nums[j] != nums[i]){
               i++;
               nums[i]=nums[j];
           }
       }
        return i+1;
    }
    /**

    * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素
    * @author      linmeng
    * @param nums 整形数组
     *@Param target 插入元素
    * @return     int 元素插入位置
    * @exception
    * @date        2019/5/25 23:06
    */
    public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target <= nums[i]){
                return i;
            }else{
                if(nums.length <=i+1){
                    return i+1;
                }else{
                    if (target <=nums[i+1]){
                        return i+1;
                    }else {
                        i++;
                    }
                }

            }
        }
        return nums.length;
    }
}
