package com.example.demo.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-3:03 下午
 * @Desc
 */

public class zigzagLevelOrder_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root == null){
            return res;// 又忘记这一坨
        }

        queue.offer(root);// 老是忘记写这个！！

        int zigflag = 0;
        while (!queue.isEmpty()){

            LinkedList<Integer> level = new LinkedList<>();

            int count = queue.size();
            for (int i = 0; i < count; i++) {

                TreeNode curnode = queue.poll(); //queue poll offer顺序不变，只是 最终的打印数组的里的存储顺序变了


                if (curnode.left != null){
                    queue.add(curnode.left);
                }
                if (curnode.right != null){
                    queue.add(curnode.right);
                }

                //                level.add(curnode); // 唯一要改的就是这里打印数组的后插方式
                if (zigflag%2 ==0 ){
                    level.offerLast(curnode.val);
                }else {
                    level.offerFirst(curnode.val);
                }

            }

            zigflag = zigflag+1; //
            res.add(level);

        }
        return res;

    }


}
