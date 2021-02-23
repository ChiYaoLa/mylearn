package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/7-8:29 下午
 * @Desc
 */

public class permute_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> pathRes = new ArrayList<>();
        dfs(nums,new ArrayList<Integer>(),pathRes );
        return pathRes;
    }

    public void dfs(int[] nums,List<Integer> path,List<List<Integer>> pathRes){

        if (nums.length == 0){
            pathRes.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            //到达回溯树末端节点


            // 全排列 怎么想象这个回溯树呢？其实很好想象
            int cur_num = nums[i];
            // 其实我就是想做一个数组切片操作，但是java太恶心了，没有python的api
            // 这里投机取巧，借助数组元素都不相同，过滤掉第i个元素完成
            int[] cur_nums = Arrays.stream(nums).filter(value -> value != cur_num).toArray();


            path.add(cur_num);
            dfs(cur_nums,path,pathRes);
            path.remove(path.size()-1);

        }
    }


}
