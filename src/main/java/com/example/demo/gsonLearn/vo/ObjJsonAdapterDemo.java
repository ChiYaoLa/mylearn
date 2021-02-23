package com.example.demo.gsonLearn.vo;

import com.example.demo.gsonLearn.utils.DemoObjDerserize;
import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description 带了JsonAdapter
 * @Author: xuliang98
 * @Date: 2020/9/28 18:14
 */
//@JsonAdapter(DemoObjDerserize.class)
@NoArgsConstructor
@Data
public class ObjJsonAdapterDemo {


    /**
     * name : ALemon
     * age : 24.2
     * car : null
     * major : ["敲代码","学习"]
     * Nativeplace : {"city":"广州","country":"China"}
     */

    private String name;
    private double age;
    private Object car;
    private NativeplaceBean Nativeplace;
    private List<String> major;


    @JsonAdapter(DateFormatDerSerializer.class)
    private Date time;

    @NoArgsConstructor
    @Data
    public static class NativeplaceBean {
        /**
         * city : 广州
         * country : China
         */

        @SerializedName(value = "city",alternate = {"city2","city1"})
        private String city;

        @Expose(deserialize = false)
        private String country;
    }

    public ObjJsonAdapterDemo(String name) {
        this.name = name;
    }

    /**反序列化化阶段 ***/
    public class DateFormatDerSerializer implements JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement jsonElement, Type type,
                                JsonDeserializationContext context) throws JsonParseException {

            String element = jsonElement.getAsString();
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(element);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

    /*** 序列化阶段 ***/
    public class DateFormatSerializer implements JsonSerializer<Date>{
        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String s = dateFormat.format(date);
            return context.serialize(s);
        }
    }





}
