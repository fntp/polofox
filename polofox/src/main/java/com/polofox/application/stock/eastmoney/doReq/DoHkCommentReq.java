package com.polofox.application.stock.eastmoney.doReq;

import com.polofox.application.stock.eastmoney.bean.Comment;
import com.polofox.application.stock.eastmoney.service.ListService;
import com.polofox.application.stock.eastmoney.service.impl.ListServiceImpl;
import com.polofox.application.stock.eastmoney.utils.GeReqUrlInfo;
import com.polofox.log.Log;

import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: DoHkCommentReq
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-13:49
 */
public class DoHkCommentReq {
    private static final ListService SERVICE = new ListServiceImpl();
    public static List<Comment> getCommentList(String hKCode){
        Log.log();
        return SERVICE.getHkStockDfCommentList(GeReqUrlInfo.getQuoteCoreUrl() + hKCode);
    }
}
