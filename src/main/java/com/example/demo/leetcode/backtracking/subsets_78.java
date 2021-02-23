package com.example.demo.leetcode.backtracking;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/7-11:55 下午
 * @Desc
 */

public class subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> pathRes = new ArrayList<>();
        pathRes.add(new ArrayList<>());  // 本来没加这句，结果为空，二维数组需要 注意了

        finonaci(nums,0,pathRes);
        return pathRes;

    }

    // 具体逻辑 主要就是 当前选择nums[cur] 与 已有结果pathRes 的逻辑,
    // 感觉很有斐波那契的味道
    public void finonaci(int[] nums,int cur,List<List<Integer>> pathRes){

        if (cur == nums.length){
            return;
        }

        int cur_option = nums[cur]; // 当前选择

        // 一波流操作 绚丽爆炸
        List<List<Integer>> new_add = pathRes.stream().map(u -> {
            ArrayList<Integer> u_clone = new ArrayList<>(u);  // 这里我新创建一个对象，不然就把原来的对象给改动了
            u_clone.add(cur_option);
            return u_clone;
        }).collect(Collectors.toList());

        pathRes.addAll(new_add);

        finonaci(nums,cur+1,pathRes);

    }

    public static void main(String[] args) {
        subsets_78 subsets_78 = new subsets_78();
        subsets_78.subsets(new int[]{1,2,3,4});
    }



}
