package com.polofox.application.stock.eastmoney.utils;

import java.io.*;

/**
 * @author Write By SunChengXin
 * @title: FileUtils
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/11/5-17:41
 */
public class FileUtils implements Serializable {
    private static final long serialVersionUID = 2044407994542868352L;
    public static void saveToLocal(String string,String path){
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("写入失败！");
        }
    }
}
