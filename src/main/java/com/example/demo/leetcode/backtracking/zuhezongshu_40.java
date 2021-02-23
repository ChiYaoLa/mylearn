package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/7-5:45 下午
 * @Desc
 */

public class zuhezongshu_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int[] sorted_Candi = Arrays.stream(candidates).sorted().toArray();
//        Arrays.stream(sorted_Candi).forEach(System.out::println);
        List<List<Integer>> pathRes = new ArrayList<>();
        dfs(sorted_Candi,target,0,new ArrayList<Integer>(),pathRes);
        return pathRes;
    }


    public void dfs(int[] candidates, int target,int begin,List<Integer> path,List<List<Integer>> pathRes){


        if (target==0 ) {
            pathRes.add( new ArrayList<Integer>(path));
//            System.out.printf(path.toString());
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i>begin && candidates[i]==candidates[i-1]){
                continue;
            }

            if (target-candidates[i] < 0){
                return;
            }

            path.add(candidates[i]);
            // 原来咱们的提前排序和 这里的小i 与begin 的配合才是剪纸的关键
            dfs(candidates,target-candidates[i],i+1,path,pathRes);
            path.remove(path.size()-1);
        }

    }



}
