package com.run.leetcode.array.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * 将N*N 数组顺时针旋转90度
 * @author 18123
 * @date 2019/8/26 14:01
 */
public class Rotate {

    public static void main(String[] args) {
        int[][]ma=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        Rotate rotate = new Rotate();
        rotate.rotate(ma);
    }
    /**
    * @Description:    先将其 按照对角线替换，然后左右替换
    * @Author:         linmeng
    * @CreateDate:     2019/8/26 14:02
    * @UpdateUser:     linmeng
    * @UpdateDate:     2019/8/26 14:02
    * @UpdateRemark:   修改内容
    
    * @Version:        1.0
    
    */
    public void rotate(int[][] matrix) {
        int len = matrix[0].length;
        /**
         * 沿着\进行替换
         */
        for (int i=0;i<len;i++){
            for (int j=0;j<i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i=0;i<len;i++){
            for (int j=0;j<len/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = tmp;
            }
        }
    }
}
