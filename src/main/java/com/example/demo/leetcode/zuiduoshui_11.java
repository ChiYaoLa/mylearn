package com.example.demo.leetcode;

/**
 * @description https://leetcode-cn.com/problems/container-with-most-water/
 * @Author: xuliang98
 * @Date: 2020/12/13 17:55
 */
public class zuiduoshui_11 {

    public int maxArea(int[] height) {
        int l=0;
        int r = height.length-1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l],height[r])*(r-l);
            ans = Math.max(ans,area);

            if (height[l]<height[r]){
                l = l+1;
            }else {
                r = r-1;
            }

        }

        return ans;

    }
}
