package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-4:46 下午
 * @Desc
 */

public class minDepth_111 {

    // 发现树递归的 题目，需要你先建设这个函数就可以帮你 获取到需要的value，基于这个假设去用 这个递归函数，最后补上return举行
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }


        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null || root.right == null){
            return left+right+1;  // 比如一条线那种情况如果，不加这个条件最后返回的可能是0  当某个孩子节点是0  对饮的left或者right是0
        }
        return Math.min(left,right)+1;
    }
}
