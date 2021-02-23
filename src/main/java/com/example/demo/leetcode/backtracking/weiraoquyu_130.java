package com.example.demo.leetcode.backtracking;

import java.util.Arrays;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/8-3:48 下午
 * @Desc
 */

public class weiraoquyu_130 {
    public void solve(char[][] board) {
        if (board.length == 0) return;

        int h = board.length;
        int w = board[0].length;
        // 先走一遍边缘
        for (int i = 0; i < w; i++) {
            dfs(board,0,i); // 最上一层
            dfs(board,h-1,i); // 最下一层
        }

        for (int i = 0; i < h; i++) {
            dfs(board,i,0); // 最左一层
            dfs(board,i,w-1); // 最右一层
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                    continue;  // 要注意了！！
                }
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                    continue;
                }

            }
        }

    }


    public void dfs(char[][] board,int i,int j ){

        // 到达此次回溯寻找的 图的末端节点
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != 'O'){
            return;
        }
        // 主要是o不能在边界上，也不与边界上的o相连，最好回溯的起点就是边界上出发然后再在正式的 走一遍全部，这样肯定可以搞出来
        // 可以反其道而做，从四周边缘入手回溯，找到o 然后着色为a？
        board[i][j] = 'A';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }

    public static void main(String[] args) {
        weiraoquyu_130 weiraoquyu_130 = new weiraoquyu_130();
        char[][] ab = {
                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}
        };
        weiraoquyu_130.solve(ab);
    }

}
