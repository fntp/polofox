package com.polofox.application.stock.eastmoney.test;

import com.polofox.application.stock.eastmoney.bean.Comment;
import com.polofox.application.stock.eastmoney.bean.HkStock;
import com.polofox.application.stock.eastmoney.doReq.DoHkCommentReq;
import com.polofox.application.stock.eastmoney.doReq.DoHkReq;
import com.polofox.application.stock.eastmoney.utils.FileUtils;

import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: TestReq
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-13:58
 */
public class ApplicationContext {
    public static void start() {
        List<HkStock> hkStockList = DoHkReq.getHkStockList();
        StringBuilder content = new StringBuilder("data:").append("\n");
        hkStockList.forEach(hkStock -> {
            List<Comment> commentList = DoHkCommentReq.getCommentList(hkStock.getStockCode());
            for (Comment comment : commentList) {
                content.append(comment.toString()).append("\n");
            }
        });
                FileUtils.saveToLocal(content.toString(),"stockInfo.txt");
    }

    public static void main(String[] args) {
        start();
    }
}
