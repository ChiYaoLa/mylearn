package com.example.demo.leetcode;

/**
 * @description https://leetcode-cn.com/problems/longest-common-prefix/
 * @Author: xuliang98
 * @Date: 2020/12/13 18:09
 */
public class longestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length ==0 || strs == null){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = findlcp(prefix,strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String findlcp(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        int index = 0;
        while (index<length && str1.charAt(index) ==  str2.charAt(index)){
            index = index+1;
        }
        return str1.substring(0,index);
    }
}
