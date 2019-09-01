package com.run.study.arithmetic.charpt2.c23;
/**
* @Description:    分治算法
* @Author:         linmeng
* @CreateDate:     2019/8/25 10:16
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/25 10:16
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class DivideAndConquerAlgorithm {

    public static void main(String[] args) {
        DivideAndConquerAlgorithm divide = new DivideAndConquerAlgorithm();
        divide.nums = new int[]{2,4,5,7,1,2,3,6};
        divide.mergeSort(divide.nums,0,divide.nums.length-1);
        System.out.println("运行结束");
    }

    /**
     * 定义需要排序的 数组
     */
    private int [] nums ;

    public void mergeSort(int[] nums,int p,int r){
        if (p<r){
            int q = Math.abs(p+r)/2;
            mergeSort(nums,p,q);
            mergeSort(nums,q+1,r);
            merge(nums,p,q,r);
        }
    }

    /**

    * 使用分治法对数组进行排序
    * @author      林猛
    * @param nums 需要排序的 数组
     * @param p 数组中已经排序好的数组1的开始角标
     * @param q 已经排序好的数组2的开始角标 ，数组1的结束角标
     * @param r 数组2的结束角标
    * @date        2019/8/25 10:19
    */
    public void merge(int[] nums,int p,int q,int r){
        // 获取 两个数组的长度
        int n1 =q-p+1;
        int n2 =  r-q;
        // 定义两个新数组，长度分别为n1，n2.
        int[] left = new int[n1];
        int[] right = new int[n2];
        // 给两数组赋值
        for (int i=0;i<n1||i<n2;i++){
            if (i<n1){
                left[i]=nums[p+i];
            }
            if (i<n2){
                right[i]=nums[q+i+1];
            }
        }
        int a=0,b=0;
        for (int k=p;k<r;k++){
            if (left[a]<=right[b]){
                nums[k]=left[a];
                a++;
            }else {
                nums[k]=right[b];
                b++;
            }
        }
    }
}
