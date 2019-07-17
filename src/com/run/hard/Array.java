package com.run.hard;
/**@TODO 暂时放弃
* @Description:    数组困难
* @Author:         linmeng
* @CreateDate:     2019/7/7 11:08
* @UpdateUser:     linmeng
* @UpdateDate:     2019/7/7 11:08
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class Array {

    /**
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。
    示例 1:
    nums1 = [1, 3]
    nums2 = [2]
    则中位数是 2.0
    示例 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    则中位数是 (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 将数组为空的两种情况提前结束
        if (nums1==null){
           return getNotNullResult(nums2);
        }

        if (nums2==null){
            return getNotNullResult(nums1);
        }
        // 判断size是奇是偶 获取中位数数量
        int size=nums1.length+nums2.length;
        boolean tmp = true;
        if (size%2 ==0){
            tmp=false;
        }
        int i=0,j=0,k=0;
        while (true){
            if (tmp){
                i++;
                if (nums1[j]<nums2[k]){
                    if (i==size/2){
                        return nums1[j];
                    }
                    j++;
                }else {
                    if (i==size/2){
                        return nums2[k];
                    }
                    k++;
                }
            }else {

            }
        }

    }

    public double getNotNullResult(int[] num){
        int i= num.length/2;
        return num.length%2==0?(num[i]+num[i-1])/2.0:num[i]/1.0;
    }
}
