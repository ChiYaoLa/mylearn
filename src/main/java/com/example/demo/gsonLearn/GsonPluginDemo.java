package com.example.demo.gsonLearn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.jd.iot.commons.utils.JsonUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @description 测试插件生产data类好使不好使
 * @Author: xuliang98
 * @Date: 2020/9/28 17:11
 */
@Slf4j
@NoArgsConstructor
@Data
public class GsonPluginDemo {


    private List<FactoriesBean> factories;

    @NoArgsConstructor
    @Data
    public static class FactoriesBean {
        /**
         * factory_id : 1111
         * factory_name : 丽水市鑫龙皮饰有限公司
         * full_name : 丽水市鑫龙皮饰有限公司
         * owner_source : xinlong
         * workshops : [{"workshop_id":"12323","workshop_name":"xl-1车间","product_lines":[{"prodline_id":"121212","prodline_name":"xl-1-1生产线","prodline_type":"YAHUA","devices":[{"device_id":"53539890400","object_type":"ELECTRIC"},{"device_id":"5353928ba00","object_type":"ELECTRIC"},{"device_id":"53538c77900","object_type":"ELECTRIC"},{"device_id":"5353827f100","object_type":"ELECTRIC"}]},{"prodline_id":"456","prodline_name":"xl-1-2生产线","prodline_type":"SANBAN","devices":[{"device_id":"53537db4d00","object_type":"ELECTRIC"},{"device_id":"535378dde00","object_type":"ELECTRIC"},{"device_id":"53535a3fa00","object_type":"ELECTRIC"},{"device_id":"5352c747500","object_type":"ELECTRIC"}]},{"prodline_id":"6788","prodline_name":"xl-1-3生产线","prodline_type":"SANBAN","devices":[{"device_id":"5352c123800","object_type":"ELECTRIC"},{"device_id":"5352b569900","object_type":"ELECTRIC"},{"device_id":"5352568ac00","object_type":"ELECTRIC"},{"device_id":"53524e82f00","object_type":"ELECTRIC"},{"device_id":"535247c2b00","object_type":"ELECTRIC"},{"device_id":"5352417c300","object_type":"ELECTRIC"},{"device_id":"53523aafe00","object_type":"ELECTRIC"}]}]},{"workshop_id":"98989","workshop_name":"xl-2车间","product_lines":[{"prodline_id":"897789","prodline_name":"xl-2-1生产线","prodline_type":"SANBAN"},{"prodline_id":"878909","prodline_name":"xl-2-2生产线","prodline_type":"ZHITU","devices":[{"device_id":"5349f117300","object_type":"STEAM"}]},{"prodline_id":"67890080","prodline_name":"xl-2-3生产线","prodline_type":"SANBAN","devices":[{"device_id":"5349e9da000","object_type":"WATER"},{"device_id":"5349e387b00","object_type":"WATER"},{"device_id":"5349dd61100","object_type":"WATER"},{"device_id":"5349b230b00","object_type":"WATER"}]}]}]
         */

        private String factory_id;
        private String factory_name;
        private String full_name;
        private String owner_source;
        private List<WorkshopsBean> workshops;

        @NoArgsConstructor
        @Data
        public static class WorkshopsBean {
            /**
             * workshop_id : 12323
             * workshop_name : xl-1车间
             * product_lines : [{"prodline_id":"121212","prodline_name":"xl-1-1生产线","prodline_type":"YAHUA","devices":[{"device_id":"53539890400","object_type":"ELECTRIC"},{"device_id":"5353928ba00","object_type":"ELECTRIC"},{"device_id":"53538c77900","object_type":"ELECTRIC"},{"device_id":"5353827f100","object_type":"ELECTRIC"}]},{"prodline_id":"456","prodline_name":"xl-1-2生产线","prodline_type":"SANBAN","devices":[{"device_id":"53537db4d00","object_type":"ELECTRIC"},{"device_id":"535378dde00","object_type":"ELECTRIC"},{"device_id":"53535a3fa00","object_type":"ELECTRIC"},{"device_id":"5352c747500","object_type":"ELECTRIC"}]},{"prodline_id":"6788","prodline_name":"xl-1-3生产线","prodline_type":"SANBAN","devices":[{"device_id":"5352c123800","object_type":"ELECTRIC"},{"device_id":"5352b569900","object_type":"ELECTRIC"},{"device_id":"5352568ac00","object_type":"ELECTRIC"},{"device_id":"53524e82f00","object_type":"ELECTRIC"},{"device_id":"535247c2b00","object_type":"ELECTRIC"},{"device_id":"5352417c300","object_type":"ELECTRIC"},{"device_id":"53523aafe00","object_type":"ELECTRIC"}]}]
             */

            private String workshop_id;
            private String workshop_name;
            private List<ProductLinesBean> product_lines;

            @NoArgsConstructor
            @Data
            public static class ProductLinesBean {
                /**
                 * prodline_id : 121212
                 * prodline_name : xl-1-1生产线
                 * prodline_type : YAHUA
                 * devices : [{"device_id":"53539890400","object_type":"ELECTRIC"},{"device_id":"5353928ba00","object_type":"ELECTRIC"},{"device_id":"53538c77900","object_type":"ELECTRIC"},{"device_id":"5353827f100","object_type":"ELECTRIC"}]
                 */

                private String prodline_id;
                private String prodline_name;
                private String prodline_type;
                private List<DevicesBean> devices;

                @NoArgsConstructor
                @Data
                public static class DevicesBean {
                    /**
                     * device_id : 53539890400
                     * object_type : ELECTRIC
                     */

                    private String device_id;
                    private String object_type;
                }
            }
        }
    }

    public static void main(String[] args) {
        String deviceFile="device.json";
        GsonPluginDemo factoryOrg;
        Gson gson = new GsonBuilder().create();
        try {
            ClassPathResource classPathResource = new ClassPathResource(deviceFile);
            factoryOrg = gson.fromJson(new InputStreamReader(classPathResource.getInputStream(),
                    StandardCharsets.UTF_8), GsonPluginDemo.class);
//            log.info("factoryOrg:{}", JsonUtil.obj2Json(factoryOrg));
        } catch (Exception e) {
            log.error("读取配置文件({})异常！{}", deviceFile, ExceptionUtils.getRootCauseMessage(e), e);
        }

    }

}
