package com.polofox.application.stock.eastmoney.service;

import com.polofox.application.stock.eastmoney.bean.AllHkStockDf;
import com.polofox.application.stock.eastmoney.bean.Comment;
import com.polofox.application.stock.eastmoney.bean.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Write By SunChengXin
 * @title: ListService
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-18:06
 */
@Service
public interface ListService {

    /**
     * 获得列表的服务
     * @param url 请求地址
     * @return 返回一个股票列表
     */
    List<AllHkStockDf> getHkStockDfList(String url);

    /**
     * 获得列表的服务
     * @param url 请求地址
     * @return 返回一个股票列表
     */
    List<Comment> getHkStockDfCommentList(String url);

    /**
     * 获得列表的服务
     * @param url 请求地址
     * @return 返回一个股票列表
     */
    List<UserInfo> getUserInfoList(String url);

    /**
     * 获得列表的服务
     * @param url 请求地址
     * @return 返回一个股票列表
     */
    List<AllHkStockDf> getUserSFollowQuoteList(String url);
}
