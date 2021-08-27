package com.polofox.application.stock.eastmoney.service;

import com.polofox.application.stock.eastmoney.bean.AllHkStockDf;

import java.util.List;
import java.util.Map;

/**
 * @author Write By SunChengXin
 * @title: ListService
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-18:06
 */
public interface ListService {

    /**
     * 获得列表的服务
     * @param url 请求地址
     * @return 返回一个股票列表
     */
    List<AllHkStockDf> getHkStockDfList(String url);
}
