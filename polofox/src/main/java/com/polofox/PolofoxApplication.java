package com.polofox;
import com.polofox.info.AppInfo;
import com.polofox.log.Log;
import java.io.IOException;
public class PolofoxApplication {
    private static final Log log = Log.getLog ();
    //  程序启动入口
    public static void main(String[] args) {
        try {
            log.init ();
            System.out.println ("CopyAllRight sinsy@stickPoint All Right Reserved");
            System.out.println ("Current Version --"+ AppInfo.VERSION);
            Log.log ();
        } catch (IOException e) {
            System.out.println ("程序启动失败！");
        }
    }
}
