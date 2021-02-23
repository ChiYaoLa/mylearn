package com.example.demo.leetcode.backtracking;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/6-4:16 下午
 * @Desc
 */

public class letterCombinations_17 {

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> optionsMap = new HashMap<>();
        optionsMap.put('2',"abc");
        optionsMap.put('3',"def");
        optionsMap.put('4',"ghi");
        optionsMap.put('5',"jkl");
        optionsMap.put('6',"mno");
        optionsMap.put('7',"pqrs");
        optionsMap.put('8',"tuv");
        optionsMap.put('9',"wxyz");

        if (digits.length()==0){
            return new ArrayList<>();
        }

        ArrayList<String> pathRes = new ArrayList<>();
        dfs(digits,0,optionsMap,new StringBuilder(), pathRes);
        return pathRes;


    }
    // 基本上 回溯算法的三个参数标配，一个来自外面函数 String digits，其他2个来自标配 String path,List<String> pathRes
    public void dfs(String digits, int index, Map<Character, String> optionsMap, StringBuilder path, List<String> pathRes){
        // 第一段 return逻辑，
        if ( index == digits.length() ){  // fixme:index == digits.length()-1 这里之前错了
            pathRes.add(path.toString());
            return;
        }
        // 第二段： 如何 进退，主要就是dfs 和 path digits 之间的逻辑
        char cell = digits.charAt(index);
        String cur_option_list = optionsMap.get(cell);

        for (int i = 0; i < cur_option_list.length(); i++) {

            path.append(cur_option_list.charAt(i));

            // 在dfs 附近我会想：需要设置什么剪支或者筛选条件么？ 由于本问题，其实是全排列，貌似是不需要的，所以不用写什么if了
            dfs(digits,index+1,optionsMap,path,pathRes);
            path.deleteCharAt(path.length()-1);
        }
    }



}
