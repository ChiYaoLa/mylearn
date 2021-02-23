package com.example.demo.jacksonLearn;

import com.example.demo.jacksonLearn.vo.CarVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @description ObjectMapper 示例
 * @Author: xuliang98
 * @Date: 2020/10/3 14:01
 */
@Slf4j
public class ObjectMapperDemo {

    private static void simpleDemo1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CarVO vo = new CarVO();
        vo.setBrand("benz");
        vo.setDoors(5);
        //优雅输出 时间值null
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
        log.info("序列化是{}",s);
        CarVO carVO = mapper.readValue(s, CarVO.class);

        // 加上时间的值
        vo.setTime(new Date());
        String s2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);
        log.info("序列化是{}",s2);
        CarVO carVO2 = mapper.readValue(s, CarVO.class);


    }

    private static void simpleDemo2(){
        ObjectMapper mapper = new ObjectMapper();
        CarVO vo = new CarVO();
        vo.setBrand("porsh");
        vo.setDoors(4);
        //在序列化时忽略值为 null 的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化的时候如果多了其他属性,不抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //如果是空对象的时候,不抛异常
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
    }

    public static void main(String[] args) throws JsonProcessingException {
        simpleDemo1();
        System.out.println("###########################################");
        simpleDemo2();
    }
}
