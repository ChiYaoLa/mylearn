package com.example.demo.leetcode;

/**
 * @description https://leetcode-cn.com/problems/palindrome-number/
 * @Author: xuliang98
 * @Date: 2020/12/13 17:30
 */
public class huiwenshu_9 {
    public boolean isPalindrome(int x) {
        if (x< 0 ||( x%10 == 0 && x!=0)){
            return false;
        }
        int reverteNum = 0;
        while (x > reverteNum){
            int pop = x%10;
            reverteNum = reverteNum*10 + pop;
            x = x/10;
        }

        return (x== reverteNum || x == reverteNum/10);

    }
}
