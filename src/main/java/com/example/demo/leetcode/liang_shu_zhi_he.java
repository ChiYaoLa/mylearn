package com.example.demo.leetcode;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description https://leetcode-cn.com/problems/two-sum/
 * @Author: xuliang98
 * @Date: 2020/12/12 15:15
 */
public class liang_shu_zhi_he {

    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
           if (hashMap.containsKey(target-nums[i])){
               return new int[]{
                       hashMap.get(target-nums[i]),i   //注意顺序
               };
           }
           hashMap.put(nums[i],i);

        }

        return new int[0];  //zhuyi
    }


}
