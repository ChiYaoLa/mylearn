package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * @description https://leetcode-cn.com/problems/3sum-closest/
 * @Author: xuliang98
 * @Date: 2020/12/13 21:50
 */
public class threeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best_sum = 10000;

        for (int i = 0; i < nums.length; i++) {

            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            };

            int L = i+1;
            int R = nums.length-1;

            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];

                if (sum == target) {
                    return target;
                }

                if (Math.abs(sum-target) < Math.abs(best_sum-target)){
                    best_sum = sum;
                }

                if (sum>target){
                    while (L<R-1 && nums[R] == nums[R-1]){  //去重
                        R = R -1;
                    }
                    R = R-1;
                }else {
                    while (L+1 < R && nums[L] == nums[L+1]){
                        L = L+1;
                    }
                    L = L + 1;
                }
            }
        }

        return best_sum;
    }


}

