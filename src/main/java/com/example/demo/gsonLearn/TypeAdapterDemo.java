package com.example.demo.gsonLearn;

import com.example.demo.gsonLearn.vo.ObjJsonAdapterDemo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.jd.iot.commons.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @description 适配器的demo
 * @Author: xuliang98
 * @Date: 2020/9/29 13:38
 */
@Slf4j
public class TypeAdapterDemo {

    /***  接管某种类型的序列化和反序列化过程 ****/
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream("D:\\IOT\\mylearn\\src\\main\\java\\com\\example\\demo\\gsonLearn\\res\\obj2demo")
                , StandardCharsets.UTF_8);
        ObjJsonAdapterDemo demo = gson.fromJson(reader, ObjJsonAdapterDemo.class);
//        log.info("带了TypeAdapter 反序列化{}", JsonUtil.obj2Json(demo));

    }


}
