package com.example.demo.leetcode.tree;

import java.util.LinkedList;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-8:00 下午
 * @Desc
 */

public class flatten_114 {

    // 这不就是先 高前序遍历，再单链表不就完事了么
    public void flatten(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return;
        }

        preorder(root,queue);
        System.out.println(queue.toArray());
        queue.stream().map(u->u.val).forEach(System.out::println);


        TreeNode prenode = null;
        while (!queue.isEmpty()){
            TreeNode curnode = queue.poll();
            if (prenode != null){
                prenode.left = null;
                prenode.right = curnode;
            }
            prenode = curnode;
            System.out.println(prenode.val);
        }

    }


    public void preorder(TreeNode root,LinkedList<TreeNode> queue){
        if (root == null) {
            return;
        }
        queue.offer(root);
        preorder(root.left,queue);
        preorder(root.right,queue);
    }




}
