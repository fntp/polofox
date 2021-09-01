package com.polofox.application.stock.eastmoney.test;

import com.polofox.application.stock.eastmoney.bean.Comment;
import com.polofox.application.stock.eastmoney.bean.HkStock;
import com.polofox.application.stock.eastmoney.doReq.DoHkCommentReq;
import com.polofox.application.stock.eastmoney.doReq.DoHkReq;

import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: TestReq
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-13:58
 */
public class TestReq {
    public static void main(String[] args) {
        List<HkStock> hkStockList = DoHkReq.getHkStockList();
        hkStockList.forEach(hkStock -> {
            List<Comment> commentList = DoHkCommentReq.getCommentList(hkStock.getStockCode());
            commentList.forEach(System.out::println);
        });
    }
}
