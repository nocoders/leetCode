package com.run.leetcode.array.simple;

/**
* @Description: 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
* @Author:         linmeng
* @CreateDate:     2019/8/10 16:48
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/10 16:48
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(arr);
    }
    /**
     * 使用快慢指针，快指针用来限定长度，慢指针用来确定最后保留数的位置
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
            int i=0,j=0;
            while(j<arr.length){
                j += arr[i]==0?2:1;
                i++;
            }
            // 判断j的长度，若j长度大于arr.length,则说明数组最后一个数为0
            j--;i--;
            if (j== arr.length){
                j--;
                arr[j--]=arr[i--];
            }
            while (j>=0){
                if (arr[i]==0){
                    arr[j--]=0;
                }
                arr[j--]=arr[i--];
            }
    }
}
