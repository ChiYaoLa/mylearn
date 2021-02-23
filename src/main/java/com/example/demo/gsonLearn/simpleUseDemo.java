package com.example.demo.gsonLearn;

import com.example.demo.gsonLearn.vo.ObjDemo;
import com.example.demo.gsonLearn.vo.ObjGenericTypeDemo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @description 简单案例
 * @Author: xuliang98
 * @Date: 2020/9/28 17:48
 */
@Slf4j
public class simpleUseDemo {

    /**   明确对象类型的 ： gson.fromJson**/
    private static ObjDemo dersFileDemo() throws FileNotFoundException {
//        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Gson gson = new GsonBuilder().create();
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream("D:\\IOT\\mylearn\\src\\main\\java\\com\\example\\demo\\gsonLearn\\res\\objdemo")
                    , StandardCharsets.UTF_8);

        ObjDemo objdemo = gson.fromJson(reader, ObjDemo.class);
        return objdemo;
    }

    /*** @SerializedName()   @Expose()**/


    /*** 泛型对象的解析  靠 new TypeToken<List<Account>>(){}.getType()  **/
    private static ObjGenericTypeDemo<String> genericTypeDersDemo1() throws FileNotFoundException {
        Type type = new TypeToken<ObjGenericTypeDemo<String>>() {}.getType();
        Gson gson = new GsonBuilder().create();
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream("D:\\IOT\\mylearn\\src\\main\\java\\com\\example\\demo\\gsonLearn\\res\\objdemo")
                , StandardCharsets.UTF_8);
        ObjGenericTypeDemo<String> o = gson.fromJson(reader, type); //可以直接写死这个ObjGenericTypeDemo<String>
        return o;
    }


    public static void main(String[] args) throws FileNotFoundException {

//        log.info("确定的类型：\n {}", JsonUtil.obj2Json(dersFileDemo()));

//        log.info("泛型：类型是：{}，\n {} ",genericTypeDersDemo1().getClass(),JsonUtil.obj2Json(genericTypeDersDemo1()));

    }

}
