package com.example.demo.leetcode.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-3:20 下午
 * @Desc
 */

public class levelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>(); //内层用array 外层用queue

        if (root == null){ // 总是忘了在树的题目 加上这个条件
            return res;
        }

        queue.offer(root);


        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode curnode = queue.poll();
                level.add(curnode.val);
                if (curnode.left != null){
                    queue.offerLast(curnode.left);
                }
                if (curnode.right != null){
                    queue.offerLast(curnode.right);
                }
            }
            res.add(level);

        }

        Collections.reverse(res);

        return res;

    }


}
