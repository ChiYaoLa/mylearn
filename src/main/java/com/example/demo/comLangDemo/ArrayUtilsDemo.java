package com.example.demo.comLangDemo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.lang3.*;


import java.util.*;

import java.util.regex.Pattern;


/**
 * @description ArrayUtils：用于对数组的操作，如添加、查找、删除、子数组、倒序、元素类型转换等
 * @Author: xuliang98
 * @Date: 2020/10/6 9:57
 */
@Slf4j
public class ArrayUtilsDemo {
    public static void hashCodeDemo(){
        List<Integer> inArr= new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> outArr = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        log.info("相同个数、相同顺序的数组hashCode会是一样的");
        log.info("inarr-->{},hashcode:{}",inArr.toArray(),ArrayUtils.hashCode(inArr));
        log.info("outarr-->{},hashcode:{}",outArr.toArray(),ArrayUtils.hashCode(outArr));

    }

    public static void arrayTransDemo(){
        //toArray：可以简便的构建一个数组
        Integer[] arr = ArrayUtils.toArray(1,2,3,4,5);
        log.info("ArrayUtils make [] length-->{}", arr.length);
        //Contains 如果某个数组包含某个值就返回true
        log.info("Contains:{}",ArrayUtils.contains(arr,3));
        //indexOf
        log.info("indexOf:{}",ArrayUtils.indexOf(arr,3));
        //ArrayUtils.addAll
        Integer[] arr2 = new Integer[]{1,2,3};
        Integer[] arr3 = ArrayUtils.addAll(arr, arr2);
        log.info("addall length:{}",arr3.length);
        // 将基本数据类型转换成外包型数据
        Integer[] integers = ArrayUtils.toObject(new int[]{1, 2, 4});
        log.info("to object length:{}",integers.length);
        log.info("toPrimitive length:{}",ArrayUtils.toPrimitive(integers).length);

        // 只有当两个数组的数据类型,长度,数值顺序都相同的时候,该方法才会返回True
        log.info("equals:{}", ArrayUtils.isEquals(new int[] { 1, 3, 2 }, new int[] { 1, 2, 3 }));
    }

    private static void charUtilsDemo(){
        log.info("ascii:{}",CharUtils.isAscii('a'));

    }

    private static void classPathUtilsDemo(){
        log.info("{}",ClassPathUtils.toFullyQualifiedName(StringUtils.class,
                "StringUtils.properties"));
    }

    private static void classUtilsDemo(){
        log.info("getShortClassName:{}", ClassUtils.getShortClassName(String.class));
        log.info("getAllSuperclasses:{}", ClassUtils.getAllSuperclasses(String.class));

        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(Arrays.asList(
                "java.lang.Integer", "java.lang.int"
        ));
        log.info("类名转类：{}",classes);
    }

    /**
     *
     *
     */
    private static void numUtilsDemo() {
        List<DemoCodeEnum> enumList = EnumUtils.getEnumList(DemoCodeEnum.class);
        log.info("getEnumList:{}", enumList);
        enumList.stream().forEach(
                node-> System.out.println("foreach:"+node)
        );
        log.info("getEnumMap");
        Map<String, DemoCodeEnum> enumMap = EnumUtils.getEnumMap(DemoCodeEnum.class);
        enumMap.forEach(
                (k,v)-> System.out.println("key "+k+" value "+v)
        );

        boolean anEnum = EnumUtils.isValidEnum(DemoCodeEnum.class, "HAPPT");
        log.info("isValidEnum:{}",anEnum);

    }


    private static void randomStringUtils(){
        // 数字参数都是表示 长度
        String s = RandomStringUtils.random(10);
        log.info("随机字符串：{}",s);

        String s1 = RandomStringUtils.random(3, 'a','b', 'c', 'd', 'e','2');
        log.info("限定数组内随机:{}",s1);

        String s2 = RandomStringUtils.randomNumeric(5, 10);
        log.info("数字:{}",s2);

        String s3 = RandomStringUtils.randomAlphabetic(5, 10);
        log.info("26字母中随机：{}",s3);

        String s4 = RandomStringUtils.randomPrint(5);
        log.info("随机打印：{}",s4);
    }

    private static void randomUtilsDemo(){
        // 返回一个0 - Integer.MAX_VALUE的随机 整数
        int anInt = RandomUtils.nextInt();
        log.info("随机int:{}",anInt);
        int anInt1 = RandomUtils.nextInt(0, 100);
        log.info("范围随机int:{}",anInt1);
    }

    public static final Pattern REGEX = Pattern.compile("^*.wd");
    private static void regExUtilsDemo(){
        String s = RegExUtils.removeAll("rerqrqewr.wd", REGEX);
        log.info("removeAll:{}",s);
    }


    private static void collectionUtilsDemo(){
        String[] arr2 = {"d","e","f"};
        List strList = new ArrayList();
        CollectionUtils.addAll(strList,arr2);
        log.info("add all:{}",strList);

        // Bag接口定义了一个集合，它可以计算一个对象出现在集合中的次数。
        HashBag<String> bag = new HashBag<>();
        bag.add("a");
        bag.add("b",2);
        log.info("hashbag: a {},b {}",bag.getCount("a"),bag.getCount("b"));

        //使用双向映射，可以使用值查找键，并且可以使用键轻松查找值。
        BidiMap<String, String> bidiMap = new TreeBidiMap<>();
        bidiMap.put("one","1");
        bidiMap.put("two","2");
        log.info("bidimap {}-{}",bidiMap.getKey("1"),bidiMap.get("one"));

        //collate 将两个已排序的集合a和b合并为一个已排序的列表，以便保留元素的自然顺序
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("e", "f");
        List<String> collate = CollectionUtils.collate(list1, list2);
        log.info("collate {}",collate);

        // 判断两个集合是否存在交集
        List<String> a = Arrays.asList("1", "2");
        log.info("containsAny {}",CollectionUtils.containsAny(list1,a));

        // 用于将一种类型的对象列表转换为不同类型的对象列表。
        Collection<Integer> collect = CollectionUtils.collect(a, new Transformer<String, Integer>() {
            @Override
            public Integer transform(String s) {
                return Integer.parseInt(s);
            }
        });
        log.info("collect {}",collect);
    }

    public static void main(String[] args) {
        hashCodeDemo();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        arrayTransDemo();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        charUtilsDemo();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        classPathUtilsDemo();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        classUtilsDemo();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        numUtilsDemo();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        regExUtilsDemo();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        randomStringUtils();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        regExUtilsDemo();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        collectionUtilsDemo();
    }


}
