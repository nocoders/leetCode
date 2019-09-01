package com.run.study.arithmetic.charpt2.c21;
/**
* @Description:    将阿拉伯数字转汉字
 *      eg:123 to  一百二十三
* @Author:         linmeng
* @CreateDate:     2019/8/30 19:00
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/30 19:00
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class NumToChinese {

    public static void main(String[] args) {
        NumToChinese numToChinese = new NumToChinese();
        numToChinese.toChinese("1000");
    }
    private String toChinese(String string) {
        String[] s1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] s2 = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };

        StringBuilder result = new StringBuilder();

        int n = string.length();
        // 定义 是否为上一位是否为0
        boolean isZero =  false;
        for (int i = 0; i < n; i++) {

            int num = string.charAt(i) - '0';
                if (num == 0){
                    isZero = true;
                    continue;
                }else{
                    // 判断上一位数是否为0，为零则加零
                }
            // 最后一位不加个十百，判断 上一位是否为0
            if (i != n - 1) {
                result.append(s1[num]).append(s2[n - 2 - i]);
            } else {
                result.append(s1[num]);
            }
            System.out.println("  "+result);
        }

        System.out.println("----------------");
        System.out.println(result);
        return result.toString();

    }
}
