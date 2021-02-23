package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-7:56 下午
 * @Desc
 */

public class isValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);  // 这里是Long
    }

    // 这里是long
    public boolean check(TreeNode root,long min,long max){  // 对于二叉搜索树 的参数设置挺奇妙的,而且记住  整数的范围要注意

        // 到达节点的终端
        if (root==null){
            return true;
        }

        if (root.val <= min || root.val >= max){
            return false;
        }

        boolean left = check(root.left,min,root.val);
        boolean right = check(root.right,root.val,max);

        return  left && right;

    }



}
