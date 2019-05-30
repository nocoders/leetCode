package com.run.simple.array.simple;


import java.util.ArrayList;
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
        List<List<Integer>> generate = generate(4);
        int a=0;
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
        List<List<Integer>> lists = new ArrayList<>(numRows);
        if (numRows==1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            lists.add(list);
            return lists;
        }
        if (numRows == 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            lists.add(list);
            list = new ArrayList<>();
            list.add(1);list.add(1);
            lists.add(list);
        }

        for (int i=2;i<numRows;i++){
            List<Integer> list= new ArrayList<>();
            list.add(1);
            for (int j=1;j<i;j++){
                list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
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
