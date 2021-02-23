package com.example.demo.leetcode.backtracking;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/6-5:05 下午
 * @Desc
 */

public class combinationSum_39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 全局异常记得判断，这个题目的提示部分 替我么规避了，所以不用写了

        ArrayList<List<Integer>> pathRes = new ArrayList<>();

        // 要么set list  原始类型转来转去的 我都累
//        HashSet<Integer> cellsets = new HashSet<>();
//        cellsets.addAll(Arrays.stream(candidates).boxed().collect(Collectors.toList()));
//        ArrayList<Integer> integers = new ArrayList<>(cellsets);
//        Collections.sort(integers);
        // 一波流操作完成  去重+排序
        int[] new_candisets = Arrays.stream(candidates).distinct()
                .sorted()
                .toArray();


        // 直接 就是arry 操作完事了

        dfs(new_candisets, target, 0, new ArrayList<Integer>(), pathRes);


        return pathRes;

    }

    public void dfs(int[] candidates, int target,int begin,List<Integer> path,List<List<Integer>> pathRes){

        if (target<0){
            return;
        }

        if (target==0){
            pathRes.add(new ArrayList<>(path)); // 之前写错成 pathRes.add(path);  ！！！！think why！

            return ;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target- candidates[i] <0){
                return;
            }

            path.add( candidates[i]);

            // 思考剪枝条件：1.target 必须大于等于0
            //    2 怎么排除掉 重复选的情况，比如 7=2+2+3=2+3+2，这靠jianzhi技巧，
            dfs(candidates,target- candidates[i] ,i,path,pathRes);//fix


            path.remove(path.size()-1);
        }


    }

    public static void main(String[] args) {
        combinationSum_39 combinationSum_39 = new combinationSum_39();
        int[] ints = {2, 3, 6, 7};
        combinationSum_39.combinationSum(ints,7);

    }


}
