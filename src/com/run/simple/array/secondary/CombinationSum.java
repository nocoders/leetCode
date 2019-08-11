package com.run.simple.array.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description:    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的数字可以无限制重复被选取。
 * @Author:         linmeng
 * @CreateDate:     2019/8/3 16:54
 * @UpdateUser:     linmeng
 * @UpdateDate:     2019/8/3 16:54
 * @UpdateRemark:   修改内容

 * @Version:        1.0

 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }

    /**
     * 定义变量
     */
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    /**
    * @Description:    使用回溯算法加剪枝获取 组合值
    * @Author:         linmeng
    * @CreateDate:     2019/8/3 17:24
    * @UpdateUser:     linmeng
    * @UpdateDate:     2019/8/3 17:24
    * @UpdateRemark:   修改内容
    * @param residue 组合和值
    * @param start 数组开始角标
    * @param pre 临时栈
    * @Version:        1.0

    */
    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        // 判断 residue 是否为0，若为 0，直接放回空
        if (residue <=0){
            res.add(new ArrayList<>(pre));
            return;
        }
        // 从i=0 开始，开始循环，若residue 减去 数组中的元素大于0，则 栈中将该元素添加，然后递归从i开始
        for (int i=start;i<len && residue - candidates[i]>=0;i++){
            pre.add(candidates[i]);

            findCombinationSum(residue-candidates[i],i,pre);
            // 因为 residue-candidates[i]也满足 等于0 的条件，所以还需要将pre中最后一个多余的元素 出栈
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len ==0){
            return res;
        }
        // 排序
        Arrays.sort(candidates);

        this.len = len;
        this.candidates = candidates;

        findCombinationSum(target,0,new Stack<>());

        return res;
    }
}
