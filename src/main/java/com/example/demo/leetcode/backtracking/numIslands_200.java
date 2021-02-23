package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/8-3:02 下午
 * @Desc
 */


//
public class numIslands_200 {

    public int numIslands(char[][] grid) {
        int numIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果是没访问过 而且是1 ，说明发现"新大陆"
                if ( grid[i][j] == '1'){
                    numIsland = numIsland+1;
                    dfs(grid,i,j);
                }
            }
        }

        return numIsland;
    }

    //这个回溯就一场着色，一波上下左右的寻找最终的效果是把联通的"岛屿"上的点 都着色为 "0"，表示占领了,
    public void dfs(char[][] grid,int i,int j){
        // 这里肯定是到达回溯图 的末端节点，类比回溯树的逻辑一样,
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){  // 这个越界条件差点写错了
            return;  // 到达末端啥也不干 直接回撤
        }
        // 在"岛上"，每走一步就着色一个位置 1改成0
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

}
