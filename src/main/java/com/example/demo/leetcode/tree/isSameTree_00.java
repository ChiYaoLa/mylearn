package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-8:39 下午
 * @Desc
 */

public class isSameTree_00 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }



}
