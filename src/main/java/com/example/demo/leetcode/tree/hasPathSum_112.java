package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-5:00 下午
 * @Desc
 */

public class hasPathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {


        if (root == null){  // 表示：targetSum !=0 但是路已经到尽头
            return false;
        }

        if (root.left == null && root.right ==null){  //也就是到达末端节点，处理好空指针异常
            return targetSum == root.val;
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);  // 如果是 root是末端节点，那么root.left是null，这个是空指针异常
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;  // 不是交集，而是并集

    }


}
