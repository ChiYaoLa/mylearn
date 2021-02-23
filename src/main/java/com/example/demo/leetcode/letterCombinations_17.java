package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Author: xuliang98
 * @Date: 2020/12/13 22:12
 */
public class letterCombinations_17 {

    public List<String> letterCombinations(String digits) {
        // 路径
        ArrayList<String> combinations = new ArrayList<String>();

        // 选择
        HashMap<Character, String> phoneMap  = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrace(combinations,phoneMap,digits,0,new StringBuffer());
        return null;
    }

    private void backtrace(List<String> combinations, HashMap<Character, String> phoneMap, String digits, int index, StringBuffer combination) {

        if (index == digits.length()){
            return;
        }

    }


}
