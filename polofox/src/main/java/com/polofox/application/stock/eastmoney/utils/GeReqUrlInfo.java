package com.polofox.application.stock.eastmoney.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Write By SunChengXin
 * @title: GeReqUrlInfo
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-11:47
 */
public class GeReqUrlInfo {
    private static  Properties properties;
    static  {
        try {
            //InputStream resourceAsStream = GeReqUrlInfo.class.getClassLoader().getResourceAsStream("stockApi.properties");
            File file = new File("src/main/resources/stockApi.properties");
            InputStream in = new FileInputStream(file);
             properties = new Properties();
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static String getHkBaseUrl() {
        return properties.getProperty("HkBaseUrl");
    }

    public static String getQuoteCoreUrl() {
        return properties.getProperty("QuoteCoreUrl");
    }


    public static String getBaseSuffix() {
        return properties.getProperty("BaseSuffix");
    }


    public static String getBaseUserInfoCenterUrl() {
        return properties.getProperty("BaseUserInfoCenterUrl");
    }

}
