package com.run.simple.array.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
* @Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的每个数字在每个组合中只能使用一次。
* @Author:         linmeng
* @CreateDate:     2019/8/4 17:14
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/4 17:14
* @UpdateRemark:   修改内容
* @Version:        1.0

*/
public class CombinationSum2 {

    public static void main(String[] args) {
        int [] can = {10,1,2,7,6,1,5};
        int target  = 8;
        CombinationSum2 soultion = new CombinationSum2();
        List<List<Integer>> lists = soultion.combinationSum2(can, target);
        System.out.println(lists.toString());
    }

    private List<List<Integer>> res = new ArrayList<>();
    private int len;
    private int[] candidates;

    /**
     *  精髓在于pop,跳出循环的时候，说明最后一个元素已经不满足条件了，所以需要把最后一个元素 拿出来
     * @param residue
     * @param start
     * @param stack
     */
    private void findCombinationSum2(int residue, int start, Stack<Integer> stack){
        if (residue<=0){
            res.add(new ArrayList<>(stack));
            return;
        }
            for (int i=start;i<len && residue-candidates[i]>=0;i++){
                if (i>start && candidates[i] == candidates[i-1]){
                    continue;
                }
                stack.push(candidates[i]);
                findCombinationSum2(residue-candidates[i],i+1,stack);
                stack.pop();
            }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0){
            return res;
        }
        Arrays.sort(candidates);

        this.candidates = candidates;
        this.len = len;

        findCombinationSum2(target,0, new Stack<>());

        return res;
    }
}
