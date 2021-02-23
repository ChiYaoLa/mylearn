package com.example.demo.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description https://leetcode-cn.com/problems/3sum/
 * @Author: xuliang98
 * @Date: 2020/12/13 18:22
 */
public class threeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                return lists;
            };
            if (i>0&&nums[i]==nums[i-1]) {
                continue;
            };

            int L = i+1;
            int R = nums.length -1; //初始化赋值

            while (L < R){
                int tmp = nums[i] + nums[L] + nums[R];
                if (tmp == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);

                    while (L+1<R && nums[L] == nums[L+1])  {
                        L = L+1;
                    }
                    while (L<R-1 && nums[R] == nums[R-1]){
                        R = R-1;
                    }
                    L = L+1;
                    R = R-1;
                }else if (tmp<0){
                     L = L+1;
                }else {
                     R = R-1;
                }
            }

        }
        return lists;
    }
}
