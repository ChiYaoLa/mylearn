package com.example.demo.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/8-7:48 下午
 * @Desc
 */

public class generateTrees_95 {

    public List<TreeNode> generateTrees(int n) {
        // 分成两个部分，各自回溯，先左边再右边，这回是要生成这种树的所有情况
        // 这个数组肯定是有序的，任意一个点都可以root，同样的 分割之后的左右两部分，任意一个点也可可以是root，
        // 这就有思路了

        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return dfs(1,n);


    }

    // 如果说1...n  可以拆解为 root=1 []和[2..n]   root=2 [1][3..n]    root=n [1..n-1][] 这n种情况
    // 显然这可以使用左右两路dfs，难点就是 节点之间的连接生成，容易搞乱
    // 我们先把数组假设成 [1] [1,2] [1,2,3] 这最简单的三种情形，考察一下
    // [1] -> [null,1,null]   [1,2]->[ [] ]
    public List<TreeNode> dfs(int start,int end){
        ArrayList<TreeNode> nodeArrayList = new ArrayList<>();
        if (start > end){
            nodeArrayList.add(null);
            return nodeArrayList;
        }

        // 首先是root的选择
        for (int i = start; i <= end; i++) {
            List<TreeNode> left_treenodes = dfs(start, i-1);
            List<TreeNode> right_treenodes = dfs(i+1, end);

            // 拿回到最末端的nodeArrayList，开始一层层往上搭建，返回给上一层的都是 下层子树木的root节点，直接供应上一层root的🔗就完事了
            for (int lpos = 0; lpos < left_treenodes.size(); lpos++) {
                for (int rpos = 0; rpos < right_treenodes.size(); rpos++) {
                    // root 只在自己的左右的nodeArrayList中选择一个元素作为直接相连的，但是这是循环啊，肯定得
                    TreeNode root = new TreeNode(i);
                    root.left = left_treenodes.get(lpos);
                    root.right = right_treenodes.get(rpos);

                    nodeArrayList.add(root);  //因为最终的结果是中序遍历，所以先放入root元素
                }
            }
        }



        return nodeArrayList;


    }
}
