package com.example.demo.leetcode;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/14-1:53 下午
 * @Desc
 */
/*** 因为就卖出一次 所以其实遍历一边求出最大最小值 **/
public class maxProfit_121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minPrice){
                minPrice = prices[i];
            }
            if (prices[i] -minPrice > maxProfit){
                maxProfit = prices[i] -minPrice;
            }
        }
        return maxProfit;

    }


}
