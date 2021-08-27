package com.polofox.application.stock.eastmoney.bean;

import com.polofox.log.Info;

/**
 * @author Write By SunChengXin
 * @title: HKStock
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-14:49
 */
public class HkStock {
    @Info(info="股票代码")
    private String stockCode;
    @Info(info = "名称")
    private String stockName;
    @Info(info = "最新价")
    private String HKD;
    @Info(info = "涨跌额")
    private String chgE;
    @Info(info = "涨跌幅")
    private String chgF;
    @Info(info = "今开")
    private String Open;
    @Info(info = "最高")
    private String High;
    @Info(info = "最低")
    private String Low;
    @Info(info = "昨收")
    private String Close;
    @Info(info = "成交量")
    private String Vol;
    @Info(info = "成交额")
    private String TO;
}
