package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/9-1:23 下午
 * @Desc
 */

public class isSymmetric_101 {
    //
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
       return   check(root,root);
    }

    // 想象一棵镜像的树
    public boolean check(TreeNode root1,TreeNode root2){
        // 防止null 这种空指针的存在,通过前后if的顺序，就完成了 条件的筛选秒了
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        // 写的真优秀
        return root1.val == root2.val && check(root1.left,root2.right) && check(root2.right,root1.left);
    }
}
