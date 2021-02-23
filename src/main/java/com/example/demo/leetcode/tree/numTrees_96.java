package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-7:35 下午
 * @Desc
 */

public class numTrees_96 {
    // dp
    public int numTrees(int n) {
        // dp 数组表示 当前数组内元素个数为n 的时候的，quzhi
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) { // i表示当前元素数量
            for (int j = 1; j <=i; j++) {  // j 是当root的元素的index
                dp[i] += dp[j-1]*dp[i-j]; // 比如dp[2] = dp[0]*dp[1] + dp[1]*dp[0] 这个例子就可以帮助决定for循环的参数
            }
        }

        return dp[n];

    }

}
