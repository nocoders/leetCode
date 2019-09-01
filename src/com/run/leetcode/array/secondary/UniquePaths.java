package com.run.leetcode.array.secondary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径
* @Author:         linmeng
* @CreateDate:     2019/8/24 17:00
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/24 17:00
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();

        int i = uniquePaths.uniquePaths(3, 2);

        System.out.println(i);


    }

    /**

    * 方法实现说明：使用递归 ，首先从0,0开始，路线的增加的前提条件是坐标小于m，n
     *    小于mn时，就可以分成两条，否则就只有一条，所以，当a或b等于mn时，就可以
     *    结束递归 ，这个时候就有一条路线了。最后将向下的路线
     *    分为两边，00 = 01 + 10
     *    01 = 02+11 10 = 11+20
    * @author      林猛
    * @param m 列数
    * @param n 行数
    * @return     路线数量
    * @date        2019/8/24 20:36
    */
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> visit = new HashMap<>();
        if (m>n){
            return getNums3(m,n);
        }
        return getNums3(m,n);
    }
    int getNums3(int m,int n){

        int[] tmp = new int[m];
        for (int i=0;i<m;i++){
            tmp[i]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                tmp[j] = tmp[j]+tmp[j-1];
            }
        }
        return tmp[n-1];
    }
    /** 方法实现说明：使用递归 ，首先从0,0开始，路线的增加的前提条件是坐标小于m，n
     *    小于mn时，就可以分成两条，否则就只有一条，所以，当a或b等于mn时，就可以
     *    结束递归 ，这个时候就有一条路线了。最后将向下的路线
     *    分为两边，00 = 01 + 10
            *    01 = 02+11 10 = 11+20
    */
    int getNums(int a,int b,int m,int n){
        // 判断  a,b同 mn是否相等
        if (a==m  || b ==  n){
            return 1;
        }
        int res0=0,res2=0;
        if (a<=m){
            res0= getNums(a+1,b,m,n);
        }
        if (b<=n){
            res2 = getNums(a,b+1,m,n);
        }

        return res0+res2;
    }
    /**
     向右和向下的中间有一半递归是重合的，可以定义一个map，若 map中已经求过这个值，就不需要递归，直接获取
     *
     */
    int getNums2(int a, int b, int m, int n, Map<String,Integer>visit){
        // 判断  a,b同 mn是否相等
        if (a==m  || b ==  n){
            return 1;
        }
        int res0=0,res2=0;
        if (a<=m){
            //判断map中是否有值
            String key = a+1+","+b;
            if (visit.containsKey(key)){
                res0 =  visit.get(key);
            }else {

                res0= getNums2(a+1,b,m,n,visit);
            }
        }
        if (b<=n){
            String key = a+","+b+1;
            if (visit.containsKey(key)){
                res2 =visit.get(key);
            }else {

                res2 = getNums2(a,b+1,m,n,visit);
            }
        }
        visit.put(a+","+b,res0+res2);
        return res0+res2;
    }
}
