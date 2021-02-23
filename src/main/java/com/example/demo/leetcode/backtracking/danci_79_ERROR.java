package com.example.demo.leetcode.backtracking;

import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/8-10:51 上午
 * @Desc
 */

public class danci_79_ERROR {

    public boolean exist(char[][] board, String word) {



        return false;
    }

    // dfs 应该是 board(i,j) 和 word[pos] 的作用， 因为这种回溯最后只需要判断true false，不需要保存中间状态的结果，所以没有path pathRes入参
    public Boolean dfs(char[][] board, int i,int j, String word, int pos){
        //大部分都是不对的情况，return false，
        // 而正确的都不return，所以就可以保证如果满足条件的情况，是可以一直向下走的，
        if (board[i][j] != word.charAt(pos)){
            return false;
        }

        //
        // 当前board的字符 满足 和字符串的第一个元素  相同，再开始尝试dfs
        if (board[i][j] == word.charAt(pos)){
            // dfs 是向是4个方向 上下左右
            dfs(board,i+1,j,word,pos+1);
            dfs(board,i-1,j,word,pos+1);
            dfs(board,i,j+1,word,pos+1);
            dfs(board,i,j-1,word,pos+1);

        }

        return true;

        }



}
