package com.example.demo.jacksonLearn.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description TODO
 * @Author: xuliang98
 * @Date: 2020/10/3 14:04
 */
@Data
@JsonPropertyOrder({"doors","brand","time"})
public class CarVO implements Serializable {

    @JsonProperty("car_brand")
    private String brand;

    private Integer doors;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
}
