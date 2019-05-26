package com.run.simple.array.simple;


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
        int [] nums={1,3};
        searchInsert(nums,3);
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