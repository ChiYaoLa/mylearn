package com.example.demo.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class validBracket_20 {

    public boolean isValid(String s) {

        if (s.length() %2 != 0){
            return false;
        }

        HashMap<Character, Character> bracketmap = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        LinkedList<Character> stack = new LinkedList<>();


        for (int i = 0; i < s.length(); i++) {
            Character cur_char = s.charAt(i);
            if (bracketmap.containsKey(cur_char)){ //右半边括号
                if (stack.isEmpty() || stack.peek() != bracketmap.get(cur_char)){
                    return false;
                }
                stack.pop();
            }else { //左半边的括号
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty(); //比如最后剩下 【}  也是错的，

    }
}
