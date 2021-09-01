package com.polofox.application.stock.eastmoney;

import com.polofox.info.AppInfo;
import com.polofox.log.Log;

import java.io.IOException;

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
        } catch (
                IOException e) {
            System.out.println ("Polofox程序启动失败！");
        }
    }
}
