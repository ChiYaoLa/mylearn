package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/7-11:39 下午
 * @Desc
 */

public class combine_77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        List<List<Integer>> pathRes =  new ArrayList<>();
        dfs(nums,k,0,new ArrayList<Integer>(),pathRes);
        return pathRes;

    }

    public void dfs(int[] nums, int k,int begin,List<Integer> path,List<List<Integer>> pathRes){
        if ( k==0 ){
            pathRes.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++) {

            path.add(nums[i]);
            dfs(nums,k-1,i+1,path,pathRes);
            path.remove(path.size()-1);

        }
    }



}
