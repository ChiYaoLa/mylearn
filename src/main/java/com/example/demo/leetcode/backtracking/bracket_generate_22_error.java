package com.example.demo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class bracket_generate_22_error {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {

            return new ArrayList<>();
        }

        return null;


    }

    /****
     * 思路：回溯法，分成 当前选择、分支路径、路径汇总
     * 递归结束条件是 选择的括3对括号全部用完。
     * 整个复杂度是一个 卡特兰数
     *
     * 需要跟外围的 n 产生联系，每次选择其实都会影响这个 n，比如n-1 ，n 就是单个括号 使用的最大次数
     */
    public void backtrace(List<Character> currentOption , StringBuilder path,List<StringBuilder> pathRes ,int left_n,int right_n){

        // 此处是路径的出口
        if (left_n == 0 && right_n==0 ){
            // 路径达到树的末端，当前结果 有两种可能性：1. 符合括号匹配原则的路径 2。不符合原则。
            // 我们应该把 符合括号匹配原则的 路径加入，不符合的路径不加入，而且
            // fix： 显然上述的想法有问题：我们直接把 n 当作单侧括号 使用的最大次数，那么当n达到0 也就是 单侧括号到达尽头，这个递归结束条件到底怎么写呢？？
            // 是 1.  n==0 return 显然不对，return在回溯算法里 肯定是达到路径终点才发生的，一个路径表示一个符合条件的解。
            // 那么当前路径的长度和n的数值  双重判断依据，就可以成为 r路径达到条件的依据
            pathRes.add(path);

            return;
        }


        // 下面是每次选择的具体执行逻辑,回溯分成 加入和撤销，  这个我可以想象一个 回溯树，咱们先想好如何 通过进完成一个路径，再考虑 怎么 补上"退"，也就是回溯的逻辑
        if (left_n != 0){
            // 进 , 也就是怎么通过当前的选择 完成当前路径 的选择
            path.append('(');
            // 递归调用
            backtrace(currentOption,path,pathRes,left_n-1,right_n);
            // 退
            path.deleteCharAt(path.length()-1);
        }

        if (right_n != 0 ){
            //进
            path.append(')');
            backtrace(currentOption,path,pathRes,left_n,right_n-1 );
            //退  有问题的是 return的过程，之前递归的每一层的 函数代码context，都只执行了一部分，也就是上一层的每个函数context的都拿着下一层的函数的context的句柄，
            // 函数递归栈终于在某一层 发生return，return就是函数调用栈中pop出去，然后把控制权缴回给 上一层函数，上一层函数肯定是 必须得把 自己的context执行到 能return的地方才能回到上一层
            path.deleteCharAt(path.length()-1);
        }
         // 可能的结果有： y有一些不符合要求的要求不能放入，现在问题就说是，
        // （（（）））      (()())    (())()    (()))(    (()





    }






}
