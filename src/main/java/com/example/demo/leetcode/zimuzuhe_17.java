package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zimuzuhe_17 {
    public List<String> letterCombinations(String digits) {

        ArrayList<String> combinations = new ArrayList<>();
        HashMap<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrace(combinations,new StringBuffer(),digits,phoneMap,0);

        return combinations;
    }


    public void backtrace(ArrayList<String> combinations,StringBuffer combination,String digits,HashMap<Character, String> phoneMap,int index){
        if (digits.length() == index+1){
            combinations.add(combination.toString());
        }

        char digit = digits.charAt(index);
        String candicates = phoneMap.get(digit);
        for (int i = 0; i < candicates.length(); i++) {
            char cur_char = candicates.charAt(i);//当前字母
            combination.append(cur_char);
            backtrace(combinations,combination.append(cur_char),digits,phoneMap,index+1);
            combination.deleteCharAt(combination.length()-1); //pop zuihouyifge
        }
        
        
    }

}
