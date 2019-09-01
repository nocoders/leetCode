package com.run.leetcode.array.simple;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum1(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /*两数之和:暴力寻找*/
    /*一遍hash表，*/
    public static int[] twoSum3(int[] nums, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                return new int[]{i, map.get(res)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //    两遍hash表，先全部存储到map里面，然后，循环 遍历数组，判断数组里面有没有被map数据包含

    public int[] twoSum2(int[] nums, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                return new int[]{i, map.get(res)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && i != j) {
                    a[0] = i;
                    a[1] = j;

                }
            }
        }
        return a;
    }
}
