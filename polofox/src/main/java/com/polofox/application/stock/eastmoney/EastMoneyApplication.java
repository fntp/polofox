package com.polofox.application.stock.eastmoney;

import com.polofox.application.stock.eastmoney.test.ApplicationContext;
import com.polofox.info.AppInfo;
import com.polofox.log.Log;
/**
 * @author Write By SunChengXin
 * @title: StockApplication
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/25-16:44
 */
public class EastMoneyApplication {
    private static final Log log = Log.getLog ();
    public static void main(String[] args) {
        try {
            log.init ();
            System.out.println ("CopyAllRight sinsy@stickPoint All Right Reserved");
            System.out.println ("Current Version --"+ AppInfo.VERSION);
            Log.log ();
            ApplicationContext.start();
        } catch (Exception e) {
            System.out.println ("Polofox程序启动失败！");
        }
    }
}
