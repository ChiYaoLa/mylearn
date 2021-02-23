package com.example.demo.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/8-7:28 下午
 * @Desc
 */

public class zhongxubianli_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    public void dfs(TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }

        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }
}
