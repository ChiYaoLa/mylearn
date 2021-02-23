package com.example.demo.gsonLearn.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description 泛型
 * @Author: xuliang98
 * @Date: 2020/9/29 13:42
 */
public class ObjGenericTypeDemo<T> {
    /**
     * name : ALemon
     * age : 24.2
     * car : null
     * major : ["敲代码","学习"]
     * Nativeplace : {"city":"广州","country":"China"}
     */

    private T name;
    private double age;
    private Object car;
    private NativeplaceBean Nativeplace;
    private List<T> major;

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

}
