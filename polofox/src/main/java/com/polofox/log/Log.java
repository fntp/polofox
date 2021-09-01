package com.polofox.log;
import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final Log log = new Log ();
    private Log(){}
    public static Log getLog() { return log; }
    @Test
    public void test() throws IOException {
        log();
        init();
    }

    @Info(info ="启动POLOFOX服务")
    public void init() throws IOException {
        InputStream resourceAsStream =this.getClass().getClassLoader().getResourceAsStream("polofox.txt");
        assert resourceAsStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String cache;
        while ((cache = reader.readLine()) != null) {
            System.out.println(cache);
        }
    }

    public static void log(){
        new Thread(()->{
            @Info(info = "获得方法调用栈")
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement a : stackTrace) {
                System.out.println(getTimeStampWithFormatter()+"FileName:"+a.getFileName()+"-className:"+a.getClassName()+"-methodName:"+a.getMethodName()+"()-lineNumber:"+a.getLineNumber());
            }
        }).start();
    }
    public static String getTimeStampWithFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy:MM:dd:HH:mm:ss:SSS");
        String dateTime = LocalDateTime.now (ZoneOffset.of ("+8")).format (formatter);
        return "GMT-"+ dateTime +"ms:";
    }

    public static void log(String str){
        System.out.println(getTimeStampWithFormatter()+"-INFO-Polofox："+str);
    }
}
