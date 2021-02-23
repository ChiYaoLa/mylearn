package com.example.demo.leetcode.backtracking;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/8-4:44 下午
 * @Desc
 */

public class wordsearch_79 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    dfs(board,i,j,word,0,res,new boolean[board.length][board[0].length]); // 手滑i j 写成 0 0, visited 每一次都不是公用的要重新初始化
                }
            }
        }
        System.out.println(res.size()>0?true:false);
        return res.size()>0?true:false;

    }
    // 由于这个只是判断boolean，所以以前回溯模版的pathres 这里直接用一个 boolean类型的res 代替就完事了
    public void dfs(char[][] board, int i, int j, String word, int pos, List<Boolean> res,boolean[][] visited){

        //下面这两个都是return，但是调换一下顺序，就直接数组越界的bug！！！注意了

        // 到达回溯末端做回退：数组越界，或者 已经访问过 或者 不相等
        if (i<0 || i>=board.length ||j<0 || j>=board[0].length ||visited[i][j]==true|| board[i][j] != word.charAt(pos)){
            return;
        }

        // //word的最后一个元素都匹配上了，那就是true了
        if (pos == word.length()-1   &&word.charAt(pos) == board[i][j] ){
            res.add(true);
            return;
        }


        // 反正不管做不做的来，四个方向的搜索跑不了
        visited[i][j]=true;
        dfs(board,i-1,j,word,pos+1,res,visited);

        dfs(board,i+1,j,word,pos+1,res,visited);

        dfs(board,i,j+1, word,pos+1,res,visited);

        dfs(board,i,j-1,word,pos+1,res,visited);
        visited[i][j]=false;
    }


    public static void main(String[] args) {
        wordsearch_79 wordsearch_79 = new wordsearch_79();
        char[][] table =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

//        wordsearch_79.exist(table,"ABCCED");
        wordsearch_79.exist(table,"SEE");
    }


}
