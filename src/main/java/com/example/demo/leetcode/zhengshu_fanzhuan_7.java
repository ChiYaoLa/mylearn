package com.example.demo.leetcode;

/**
 * @description https://leetcode-cn.com/problems/reverse-integer/
 * @Author: xuliang98
 * @Date: 2020/12/13 16:54
 */
public class zhengshu_fanzhuan_7 {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x%10;  // 余数
            x = x/10;  //商
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE && pop>7) ) {
                return 0;
            }
            if (rev <Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE && pop < -8)){
                return 0;
            }

            rev = rev*10+pop;
        }
        return rev;
    }
}
