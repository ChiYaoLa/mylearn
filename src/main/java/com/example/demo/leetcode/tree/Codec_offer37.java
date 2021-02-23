package com.example.demo.leetcode.tree;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-9:35 下午
 * @Desc
 */

public class Codec_offer37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //bfs 走一波
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        LinkedList<TreeNode> res = new LinkedList<>(); // 用来承接结果的
        while (!queue.isEmpty()){

            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode curnode = queue.poll();
                res.offer(curnode); //res 接住抛出的结果

                if (curnode != null){
                    queue.offer(curnode.left);  // null 也要保留住结果
                    queue.offer(curnode.right);
                }

            }
        }
        // res 怎么转化为 string
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < res.size(); i++) {
            TreeNode node = res.get(i);
            if (node != null){
                builder.append(node.val);
            }else {
                builder.append("null");
            }
            if (i != res.size()-1){
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]"){
            return null;
        }

        String[] splitarr = data.substring(1, data.length() - 1).split(",");
//        Arrays.stream(splitarr).forEach(System.out::println);
        // 干脆先做个TreeNode数组
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < splitarr.length; i++) {
            if ( !splitarr[i].equals("null") ){
                System.out.println(i+splitarr[i]);
                queue.offer( new TreeNode(Integer.valueOf(splitarr[i])) );
            }else {
                queue.offer(null);
            }

        }
        // 其实规律很明显，n ->(n*2+1, n*2+2)
        int n=0;
        while (n*2+2 < splitarr.length){
            TreeNode rootnode = queue.get(n);
            if (rootnode != null){
                rootnode.left = queue.get(n*2+1);
                rootnode.right = queue.get(2*n+2);
            }

            n = n+1;
        }
        return queue.get(0);
    }

    public static void main(String[] args) {
        Codec_offer37 codec_offer37 = new Codec_offer37();
        codec_offer37.deserialize("[1,2,3,null,null,4,5]");
    }

}
