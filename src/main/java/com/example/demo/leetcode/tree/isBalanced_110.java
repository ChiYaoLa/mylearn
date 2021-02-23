package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-4:29 下午
 * @Desc
 */

public class isBalanced_110 {

    public boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }
        boolean state = Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        return  state && isBalanced(root.left) && isBalanced(root.right); // 原来是忘了 isBalanced(root.left) && isBalanced(root.right) 这一茬


    }
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left,right)+1;
    }



}
