package com.run.study.arithmetic.charpt2.c21;

import java.util.HashMap;

/**
* @Description:    插入排序
* @Author:         linmeng
* @CreateDate:     2019/8/20 21:31
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/20 21:31
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class InsertionSort {

    public static void main(String[] args) {
        int [] nums1 = {1,1,1,0,1};
        int [] nums2 =   {1,0,0,1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.bitSum(nums1,nums2);
    }
    /**

    * 对指定的数组进行排序：（升序）
     *      插入排序，
     *      从第二个元素开始，
     *      将第二个元素作为一个临时变量保存
     *      判断该元素同上一个元素谁大，
     *          若没有前一个元素大的话，当前元素替换为上一个元素，循环替换直到数组头部或者不能替换为止
     *          最后将不能替换的元素后一个元素赋值为之前的那个临时变量
    * @author      林猛
    * @param nums 未排序数组
    * @return  {@link int[]} 排序完成的数组
    * @date        2019/8/20 21:31
    */
    public int[] insertionSort(int[] nums){
        // 判断数组大小
        if (nums.length<2){
            throw new IllegalArgumentException("数组 长度小于2，无法进行排序");
        }
        // 循环判断

        for (int i=1;i<nums.length;i++){
            int tmp = nums[i];
            int j=i-1;
            /**判断之前的元素是否比nums【i] 大，若比他大就将现在的这个元素替换成上一个元素，
             * 直到当前元素没有nums[i]大的时候，
             * 最后将nums[i]等于tmp
             */

            while (j>=0 && nums[j]>tmp){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1] = tmp;
        }

        return nums;
    }

    /**
     * 倒序排序：这个同上一个原理相同，同理也可以从前往后进行遍历，但是 判断条件需要修改
     *          之前的判断条件为上一个元素是否大于当前元素，大于则将当前元素进行覆盖
     *          现在修改为是否小于 当前元素 ，小于当前元素就修改
     * @param nums
     * @return
     */
    public int[] insertionSort2(int[] nums){
        // 判断数组长度 是否小于 2，小于2，直接跑异常
        if (nums.length<2){
            throw  new IllegalArgumentException("数组长度小于2 无法进行排序");
        }
        // 循环遍历
        for (int i=1;i<nums.length;i++){

            int tmp =  nums[i];

            int j=i-1;
            while (j>=0 && nums[j]<tmp){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=tmp;
        }

        return nums;
    }

    /**
     * 两数组二进制相加
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] bitSum(int[] nums1,int[] nums2){
        // 判断两个数组长度是否为0 若其中一个为0，直接将另一个返回，若两个都为0，抛异常
        if (nums1.length==0){
            if (nums2.length==0){
                throw new IllegalArgumentException("传入量数组长度均为0");
            }else {
                return nums2;
            }
        }
        if (nums2.length==0){
            if (nums1.length==0){
                throw new IllegalArgumentException("传入量数组长度均为0");
            }else {
                return nums1;
            }
        }

        int len1 =  nums1.length;
        int len2 =  nums2.length;
        int len = len1>len2?len1+1:len2+1;
        int[] res = new int[len];
        // 将长度较长的数组赋值给新数组,赋值完成后 ，直接 进行相加
        if (len1>len2){
            System.arraycopy(nums1,0,res,1,len1);
            for (int i=0;i<len2;i++){
                res[len-i-1]+=nums2[len2-i-1];
            }
        }else {
            System.arraycopy(nums2,0,res,1,len2);
            for (int i=0;i<len1;i++){
                res[len-i-1]+=nums1[len1-i-1];
            }
        }
        // 两数组添加完毕，进行进位
        for (int i=len-1;i>0;i--){
            if (res[i]>=2){
                res[i-1]+=1;
                res[i]-=2;
            }
        }
        return res;
    }
}
