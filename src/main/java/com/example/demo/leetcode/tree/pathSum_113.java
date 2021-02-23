package com.example.demo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-5:16 下午
 * @Desc
 */

public class pathSum_113 {



    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathRes = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null){  //外层的这个null 真的是很容易忘记
            return pathRes;
        }

        path.add(root.val); // 把头节点记得加入
        dfs(root,targetSum,path,pathRes);



        return pathRes;


    }

    public void dfs(TreeNode root, int targetSum,List<Integer> path,List<List<Integer>> pathRes){

        if (root == null){
            return;
        }
        // 末端节点的value 恰好等于和
        if (root.left == null && root.right == null && root.val == targetSum){
            pathRes.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null){  //干脆就加一个这个条件万完试
            path.add(root.left.val);
            dfs(root.left,targetSum-root.val,path,pathRes);
            path.remove(path.size()-1);
        }

        if (root.right != null){
            path.add(root.right.val);
            dfs(root.right,targetSum-root.val,path,pathRes);
            path.remove(path.size()-1);
        }


    }


}
