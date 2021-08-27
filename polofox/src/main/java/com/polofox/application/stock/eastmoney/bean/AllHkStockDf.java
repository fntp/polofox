package com.polofox.application.stock.eastmoney.bean;
import com.polofox.log.Info;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 东方财富的全部港股API对接字段
 * @author Write By SunChengXin
 * @title: AllHkStockDf 东方财富的全部港股表单对应字段API绑定数据
 * @projectName polofox polofox爬虫
 * @Modifier: SunChengXin @fntp
 * @date 2021/8/27-17:10
 */
@Data
@ToString
@Getter
@Setter
public class AllHkStockDf {
    @Info(info="股票代码")
    private String f12;
    @Info(info = "名称")
    private String f14;
    @Info(info = "最新价")
    private double f2;
    @Info(info = "涨跌额")
    private double f4;
    @Info(info = "涨跌幅")
    private double f3;
    @Info(info = "今开")
    private double f17;
    @Info(info = "最高")
    private double f15;
    @Info(info = "最低")
    private double f16;
    @Info(info = "昨收")
    private double f18;
    @Info(info = "成交量")
    private long f5;
    @Info(info = "成交额")
    private double f6;
}
