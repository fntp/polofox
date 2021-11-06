package com.polofox.log;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final Log log = new Log ();
    private Log(){}
    public static Log getLog() { return log; }

    public static void main(String[] args) {
        try {
            new Log().init();
            info();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Info(info ="启动POLOFOX服务")
    public void init(){
//        InputStream inputStream = Log.class.getClassLoader().getResourceAsStream("polofox.txt");
        try {
        File file = new File("src/main/resources/polofox.txt");
        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String cache;
            while ((cache = reader.readLine()) != null) {
                System.out.println(cache);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info() throws InterruptedException {
        @Info(info = "获得方法调用栈")
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement a : stackTrace) {
            Thread.sleep(500);
            System.out.println(getTimeStampWithFormatter()+"FileName:"+a.getFileName()+"-className:"+a.getClassName()+"-methodName:"+a.getMethodName()+"()-lineNumber:"+a.getLineNumber());
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd:HH:mm:ss:SSS");
        String dateTime = LocalDateTime.now (ZoneOffset.of ("+8")).format (formatter);
        return "GMT-"+ dateTime +"ms:";
    }

    public static void log(String str){
        System.out.println(getTimeStampWithFormatter()+"-INFO-Polofox："+str);
    }
}
