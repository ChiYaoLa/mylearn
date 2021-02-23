package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/7-10:01 下午
 * @Desc
 */

public class getPermutation_60 {

    public String getPermutation(int n, int k) {
        // 生成
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i+1;
        }

        // 其实核心点是：候选数字序列1到n 本身有序，所以按照回溯dfs，走到第k个就是 第k个大小的排列
        List<StringBuilder> pathRes = new ArrayList<>();
        dfs(ints, k, new StringBuilder(),pathRes);

        return  pathRes.get(pathRes.size()-1).toString(); // 默认至少有一个结果，取出第一个结果就是


    }
    public void dfs(int[] nums, Integer k, StringBuilder path,List<StringBuilder> pathRes){
        if ( nums.length == 0 ){
            pathRes.add(new StringBuilder(path));
            return;
        }

        if ( pathRes.size() == k ){
            return ;
        }


        for (int i = 0; i < nums.length; i++) { //i正好也可以当数字用，数字是从1开始的，1到n

            int cur_num = nums[i];

            // 过滤
            int[] cur_nums= Arrays.stream(nums).filter(u -> u != cur_num).toArray();

            path.append(cur_num);    // 语法允许直接append int long等等
            dfs(cur_nums,k,path,pathRes); // 每深入一层，k-1,除此以外，候选数组n也会变化
            path.deleteCharAt(path.length()-1);
        }

    }

    public static void main(String[] args) {
        getPermutation_60 getPermutation_60 = new getPermutation_60();
        getPermutation_60.getPermutation(3,3);
    }


}
