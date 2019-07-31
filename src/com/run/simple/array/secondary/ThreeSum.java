package com.run.simple.array.secondary;

import com.run.hard.Array;

import java.util.*;

/**
 * @Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * @Author: linmeng
 * @CreateDate: 2019/5/25 15:14
 * @UpdateUser: linmeng
 * @UpdateDate: 2019/5/25 15:14
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        List<List<Integer>> lists = fourSum(nums, -9);
        System.out.println();
    }

    /**
    * @Description:    获取最接近target 的数组中三数之和，使用双指针
    * @Author:         linmeng
    * @CreateDate:     2019/7/17 22:57
    * @UpdateUser:     linmeng
    * @UpdateDate:     2019/7/17 22:57
    * @UpdateRemark:   修改内容

    * @Version:        1.0

    */
    static int threeSumClosest(int[] nums, int target) {

        //  对数组排序
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[nums.length-1];
        //同三数之和相同，使用一个变量保存三数之和，一旦其他数组的三数之和同target的差距小于当前数据，就替换
        for (int i = 0; i<nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            while (j<k){
                // 若当前 的数之和同target的差小于 res，则替换
                int tmp = nums[i]+nums[j]+nums[k];
                res = Math.abs(target-tmp)<Math.abs(target-res)?tmp:res;

                // 判断tmp 决定
                if (target<tmp){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return res;
    }

    /**
    * @Description:    获取三数之和等于0 的集合
    * @Author:         linmeng
    * @CreateDate:     2019/7/16 19:48
    * @UpdateUser:     linmeng
    * @UpdateDate:     2019/7/16 19:48
    * @UpdateRemark:   修改内容
    
    * @Version:        1.0
    
    */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums != null && nums.length > 2) {
            Arrays.sort(nums);
            //  使用 双指针，i 代表 小于0 的数据
            for (int i = 0; i < (nums.length - 2); ) {
                // 小于0 的指针
                int j = i + 1;
                // 大于0 的指针
                int k = nums.length - 1;
                while (j < k) {
                    // 这个 是正好找到满足条件的情况： a+b+c==0
                    if (nums[j] + nums[k] == -nums[i]) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);

                        j++;
                        k--;
                        // 判断下一个j元素是否同上一个相同
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 判断k
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else
                        // 三数之和大于0，此时 需要 k --，然后判断k角标下的元素同之前的元素是否相同
                        if (nums[j] + nums[k] > -nums[i]) {
                            k--;
                            while (j < k && nums[k] == nums[k + 1]) {
                                k--;
                            }
                        } else {
                            j++;
                            while (j < k && nums[j] == nums[j - 1]) {
                                j++;
                            }
                        }

                }
                // i 递增
                i++;
                while (nums[i] == nums[i - 1] && i < nums.length - 2) {
                    i++;
                }
            }
        }
        return res;
    }

    /**
    * @Description:    四数之和
    * @Author:         linmeng
     * @param nums 传入数组
     * @param target 目标值（和）
     * @return {@link List<List<Integer>>}
    * @CreateDate:     2019/7/18 22:36
    * @UpdateUser:     linmeng
    * @UpdateDate:     2019/7/18 22:36
    * @UpdateRemark:   修改内容
    * @Version:        1.0

    */
    static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        // 判断数组长度是否大于3
        if (nums.length<4){
            return res;
        }
        // 对数组排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n-3;i++){
            // 第一个数去重
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            // 从i开始的四个数如果大于target，说明后面的数都大于target，直接结束循环
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            // i加上n n-1 n-2 n-3 若是还小于 target，以i开始的所有的数 都小于 target，
            if (nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target){
                continue;
            }
            for (int j=i+1;j<n-2;j++){
                // 第二个数去重
                if (j-i>1 && nums[j]==nums[j-1]){
                    continue;
                }
                // 去除第二个数中的不可能项
                if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if (nums[i]+nums[j]+nums[n-2]+nums[n-1]<target){
                    continue;
                }
                int k=j+1,l=n-1;
                while (k<l){
                    // 判断第三个数是否相同
                    if (k-j>1 && nums[k]==nums[k-1]){
                        k++;
                        continue;
                    }
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum>target){
                        l--;
                    }else if (sum<target){
                        k++;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        l--;
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
