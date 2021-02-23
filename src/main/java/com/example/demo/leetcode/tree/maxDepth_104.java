package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-7:20 下午
 * @Desc
 */

public class maxDepth_104 {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }
}
