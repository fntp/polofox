package com.sinsy.fntp.mkonlineplayer.utils;

import com.sinsy.fntp.mkonlineplayer.constraint.LocalData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Write By SunChengXin
 * @title: LocalStringUtils
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/10/22-13:15
 */
public class LocalStringUtils {

    private static Properties properties;

    /**
     * 获得本地指定配置文件的配置信息
     * @param fileName 文件名称
     * @param attribute 配置属性名
     * @return 返回的是一个配置信息
     */
    public static String getLocalProperties(String fileName,String attribute){
        InputStream inputStream = LocalStringUtils.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = properties.getProperty(attribute);
        if (Objects.isNull(property)) {
            throw new NullPointerException("当前属性值为空！！");
        }else {
            return property;
        }
    }

    /**
     * 获得拼接后的字符串url
     * @param localDataMap 字符串数组Map
     * @return url地址
     */
    public static String getAndUrl(String baseUrl,Map<String,String> localDataMap){
        for (Map.Entry<String, String> keyWard : localDataMap.entrySet()) {
           baseUrl =  baseUrl.concat(keyWard.getKey()).concat("=").concat(keyWard.getValue()).concat("&");
        }
        if (baseUrl.endsWith("&")){
            return baseUrl.concat("jw").replace("&jw","");
        }
        return baseUrl;
    }
}
