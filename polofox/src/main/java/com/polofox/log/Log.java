package com.polofox.log;
import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Log {
    private static DateTimeFormatter formatter;
    private static String dateTime;
    @Test
    public void test() throws IOException {
        log();
        init();
    }

    @Info(info ="启动POLOFOX服务")
    public void init() throws IOException {
        InputStream resourceAsStream =this.getClass().getClassLoader().getResourceAsStream("polofox.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuffer buffer = new StringBuffer();
        String cache = "";
        while ((cache = reader.readLine()) != null) {
            System.out.println(cache);
        }
    }

    public static void log(){
        @Info(info = "获得方法调用栈")
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement a : stackTrace) {
            System.out.println(getTimeStampWithFormatter()+"FileName:"+a.getFileName()+"-className:"+a.getClassName()+"-methodName:"+a.getMethodName()+"()-lineNumber:"+a.getLineNumber());
        }
    }
    public static String getTimeStampWithFormatter() {
        formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss:SSS");
        dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        return "GMT-"+dateTime+"ms:";
    }
}
