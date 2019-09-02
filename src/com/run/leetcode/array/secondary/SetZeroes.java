package com.run.leetcode.array.secondary;

import java.util.HashSet;
import java.util.Set;

/**
* @Description: 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
* @Author:         linmeng
* @CreateDate:     2019/9/1 11:45
* @UpdateUser:     linmeng
* @UpdateDate:     2019/9/1 11:45
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class SetZeroes {

    public static void main(String[] args) {
        int [][] a = {{1,1,3},{0,1,2}};
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes3(a);
    }
    /**
     * 如果哪一行中有元素等于 0 就将 该行行首列首赋值0
     * 这个时候 第一行和第一列就会重复我们添加一个布尔值来定义 第一列是否有数据 等于0
     * @param matrix
     */
    public void  setZeroes3(int[][] matrix){
        boolean rowiszero =  false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i=0;i<R;i++) {
            // 定义第一列为0
            if (matrix[i][0]==0){
                rowiszero = true;
            }
            for (int j = 1; j < C; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;

                }
            }

        }

        for (int i=1;i<R;i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if (matrix[0][0]==0){
            for (int i=0;i<C;i++){
                matrix[0][i]=0;
            }
        }

        if (rowiszero){
            for (int i=0;i<R;i++){
                matrix[i][0]=0;
            }
        }

    }

    public void  setZeroes2(int[][] matrix){
       int R = matrix.length;
       int C = matrix[0].length;
       final int modified = -1000000;

        for (int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j]==0){
                    for (int a =0;a<R;a++){
                        if (matrix[a][j]!=0){

                            matrix[a][j] =modified;
                        }
                    }
                    for (int a =0;a<C;a++){
                        if (matrix[i][a]!=0){

                            matrix[i][a] =modified;
                        }
                    }
                }
            }
        }

        for (int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j]==modified){
                    matrix[i][j]=0;
                }
            }
        }
    }

    /**
        使用额外空间：
    * 方法实现说明:先遍历一遍数组使用set记录下，再次遍历 数组，若 数组角标包括在set里面，直接修改数据为0
    * @author      林猛
    * @param matrix
    * @date        2019/9/1 11:45
    */
    public void setZeroes(int[][] matrix) {
        int collumn = matrix.length;
        int row = matrix[0].length;
        Set<Integer> col = new HashSet<>(collumn);
        Set<Integer> rol = new HashSet<>(collumn);

        for (int i=0;i<collumn;i++){
            for (int j=0;j<row;j++){
                if (matrix[i][j]==0){
                    col.add(i);
                    rol.add(j);
                }
            }
        }

        for (int i=0;i<collumn;i++){
            for (int j=0;j<row;j++){
                if (col.contains(i)|| rol.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
