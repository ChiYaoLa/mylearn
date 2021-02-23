package com.example.demo.gsonLearn.utils;

import com.example.demo.gsonLearn.vo.ObjJsonAdapterDemo;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @description 注解在类上的反序列化过程
 * 只能实现类的 反序列化
 *  对于属性的反序列化 不能使用该注解  且功能单一
 * @Author: xuliang98
 * @Date: 2020/9/29 14:37
 */
public class DemoObjDerserize implements JsonDeserializer<ObjJsonAdapterDemo> {

    @Override
    public ObjJsonAdapterDemo deserialize(JsonElement jsonElement, Type type,
                                          JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        return new ObjJsonAdapterDemo(name+"ffffff");
    }
}
