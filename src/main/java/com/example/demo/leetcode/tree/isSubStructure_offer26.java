package com.example.demo.leetcode.tree;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/10-9:07 下午
 * @Desc
 */

public class isSubStructure_offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }

        return check(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);  //求并集啊！！ 搞错了，因为是有一个解就行
    }


    public boolean check(TreeNode root1, TreeNode root2){
        if (root2==null){   // 把 b树 比较好就行
            return true;
        }
        if (root1 == null){  //表示 root2！=null  但是 root1 == null
            return false;
        }

//        if (root1.val != root2.val){  // 写错了不是return ，而是 一个需要放入最后求交集的条件
//            return false;
//        }

        boolean left = check(root1.left, root2.left);
        boolean right = check(root1.right,root2.right);

        return root1.val == root2.val && left && right;
    }


}
