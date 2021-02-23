package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/7-9:03 下午
 * @Desc
 */

public class permuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] sorted_nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> pathRes = new ArrayList<>();
        dfs(sorted_nums,new ArrayList<Integer>(),pathRes);
        return pathRes;
    }

    public void dfs(int[] nums,List<Integer> path,List<List<Integer>> pathRes){

        // 走到树的末端
        if (nums.length == 0){
            pathRes.add(new ArrayList<Integer>(path));
            return;
        }


        // 想象回溯树，主要就是数字重复这个比较麻烦，但是咱们先假设没有重复数字，然后再打补丁
        for (int i = 0; i < nums.length; i++) {
            if ( nums.length >=2 && i>=1 && nums[i] == nums[i-1]){
                continue;
            }


            int[] cur_nums = filter_nums(nums, i);

            path.add(nums[i]);
            dfs(cur_nums,path,pathRes);
            path.remove(path.size()-1);
        }

    }

    // 不得已写的下面的函数，真恶心
    public  int[] filter_nums(int[] nums,int pop_index){
        int[] res = new int[nums.length - 1];
        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j != pop_index){
                res[index] = nums[j];
                index = index+1;
            }
        }

        return res;
    }



}
