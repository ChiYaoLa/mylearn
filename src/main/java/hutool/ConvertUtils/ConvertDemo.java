package hutool.ConvertUtils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Project: mylearn
 *
 * @author xuliang98
 * File Created at 2021/2/23-6:50 下午
 * @Desc
 */

public class ConvertDemo {
    public static void main(String[] args) {

        // 转换为字符串
        int a=1;
        String res = Convert.convert(String.class, a);
        System.out.println(res);

        long[] b = {1,2,3,4};
        String res2 = Convert.toStr(b);
        System.out.println("res2-->"+res2);


        //转换为指定类型数组：
        String[] c = { "1", "2", "3", "4" };
        Integer[] res3 = Convert.toIntArray(c);
//        Stream.of(res3).forEach(System.out::println);
        System.out.println("res3-->"+res3);

        // 转换为日期对象：
        String date11 = "2017-05-06";
        Date date = Convert.toDate(date11);
        System.out.println("date-->"+date.toString());

        // 转换为集合
        Object[] rer = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(rer);
        System.out.println("list-->"+list.toString());



    }
}
