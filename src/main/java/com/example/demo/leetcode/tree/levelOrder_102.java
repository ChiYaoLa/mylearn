package com.example.demo.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-1:59 下午
 * @Desc
 */

public class levelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.offer(root);  //bfs队列初始状态得有一个元素


        while (queue.size()>0){
            System.out.println(queue.size());
            ArrayList<Integer> level = new ArrayList<>();
            int count= queue.size();
            for (int i = 0; i < count; i++) {  // 把上一层的便利完才出这个循环
                TreeNode curnode = queue.poll();
                level.add(curnode.val);
                if (curnode.left != null){
                    queue.offer(curnode.left);  // fixbug：把curnode写成了 root
                }
                if (curnode.right != null){
                    queue.offer(curnode.right);
                }
            }

            res.add(level);
        }

        return res;

    }




}
