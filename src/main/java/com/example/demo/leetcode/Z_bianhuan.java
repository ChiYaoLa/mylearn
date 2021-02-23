package com.example.demo.leetcode;

import java.util.ArrayList;

/**
 * @description https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author: xuliang98
 * @Date: 2020/12/12 17:12
 */
public class Z_bianhuan {

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows,s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;  //行数
        boolean goingDown = false; //方向

        for (char c:s.toCharArray()){
            rows.get(curRow).append(c);

            if (curRow ==0 || curRow == numRows-1){
                goingDown = !goingDown;
            }

            curRow += goingDown?1:-1;
        }


        StringBuilder ans = new StringBuilder();
        for (StringBuilder ret:rows){
            ans.append(ret);
        }
        return ans.toString();

    }
}
