package com.run.simple.array.secondary;

import java.util.*;

/**
* @Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
* @Author:         linmeng
* @CreateDate:     2019/5/25 15:14
* @UpdateUser:     linmeng
* @UpdateDate:     2019/5/25 15:14
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println();
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums != null && nums.length >  2){
            Arrays.sort(nums);
            //  使用 双指针，i 代表 小于0 的数据
            for (int i =0 ;i< (nums.length-2);){
                // 小于0 的指针
                int j = i+1;
                // 大于0 的指针
                int k =nums.length-1;
                while (j<k){
                    // 这个 是正好找到满足条件的情况： a+b+c==0
                    if (nums[j]+nums[k] ==  -nums[i]){
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);

                        j++;
                        k--;
                        // 判断下一个j元素是否同上一个相同
                        while (j<k && nums[j]==  nums[j-1]){
                            j++;
                        }
                        // 判断k
                        while (j<k && nums[k]==nums[k+1]){
                            k--;
                        }
                    }else
                        // 三数之和大于0，此时 需要 k --，然后判断k角标下的元素同之前的元素是否相同
                        if (nums[j]+nums[k] >  -nums[i]){
                            k--;
                            while (j<k && nums[k] == nums[k+1]){
                                k--;
                            }
                    }else{
                            j++;
                            while (j<k && nums[j]== nums[j-1]){
                                j++;
                            }
                        }

                }
                // i 递增
                i++;
                while (nums[i] == nums[i-1] && i<nums.length-2){
                    i++;
                }
            }
        }
        return res;
    }
}
