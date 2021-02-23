package com.example.demo.leetcode;

import java.util.HashSet;

/**
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复子串
 * @Author: xuliang98
 * @Date: 2020/12/12 16:33
 */
public class wuchongfuzifu_zuichangzichuan {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        int right=-1;
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0){
                characters.remove(s.charAt(i-1));
            }
            while (right+1 < s.length() && !characters.contains(s.charAt(right+1))){
                characters.add(s.charAt(right+1));
                ++right;
            }
            ans = Math.max(ans,right-i+1);
        }
        return ans;

    }

}
