package com.polofox.application.music.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtil {
    /**
     * @param str
     * @return
     */

    public static String getValue(String str,String start,String end) {
        String regex = start+"(.*?)"+end;
        String param ="";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        while (m.find()) {
            int i = 1;
            param+=m.group(i);
            i++;
        }
        return param;
    }

    public static void writeDown(String str,String fileName){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("E:\\work\\"+fileName+".txt"));
            out.write(str);
            out.close();
        } catch (Exception e) {
        }
    }
}
