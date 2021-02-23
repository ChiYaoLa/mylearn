package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/6-3:23 下午
 * @Desc
 */

public class generateParenthesis_22 {


    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> pathres = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        // String类在常量池，所以 List<String>也在常量池，无惧函数形参的copy？
        dfs(n, n, path,pathres);


        return pathres;


    }


    // 想象成 树形结构的遍历，那就是dfs，如果 currentOption 往往根据其他逻辑是绑定的，可以不写
    // 直接用left right 代替n，反而更方便
    public void dfs(int left,int right,StringBuilder path,List<String> pathRes){

        //pathRes 只在path达到规则时候改return的时候才用到
        if (0==left && 0 == right & 0 != path.length()){
            pathRes.add(path.toString());
            return ;
        }


        if (left != 0){
            path.append('(');
            dfs(left-1,right,path,pathRes);
            path.deleteCharAt(path.length()-1);

        }

        // 因为是n-1 才是递归前进，所以right<left
        if (right>left){
            path.append(")");
            dfs(left,right-1,path,pathRes);
            path.deleteCharAt(path.length()-1);
        }

        // 为什么回溯不会重复？？
        // 所以最终遍历的结果是： ((()))  (()())  (())()  ()(())  ()()()  ""
    }

    public static void main(String[] args) {
        generateParenthesis_22 generateParenthesis_22 = new generateParenthesis_22();
        generateParenthesis_22.generateParenthesis(3);
    }





}
