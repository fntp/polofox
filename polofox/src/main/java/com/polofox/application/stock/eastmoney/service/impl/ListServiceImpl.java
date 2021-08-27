package com.polofox.application.stock.eastmoney.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.polofox.application.stock.eastmoney.bean.AllHkStockDf;
import com.polofox.application.stock.eastmoney.httpreq.EastHttpReq;
import com.polofox.application.stock.eastmoney.service.ListService;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Write By SunChengXin
 * @title: ListServiceImpl
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-18:09
 */
public class ListServiceImpl implements ListService {

    @Resource
    private EastHttpReq httpReq = new EastHttpReq();

    @Override
    public List<AllHkStockDf> getHkStockDfList(String url) {
        // 第一步 拿到Document
        String jsonStr = "";
        try {
            jsonStr = httpReq.getJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第二步 转成JsonList
        JSONObject responseJson = JSONObject.parseObject(jsonStr);
        JSONObject object = responseJson.getJSONObject("data");
        String diff = object.getString("diff");
        List<AllHkStockDf> hkStockDfList = new ArrayList<>();
        hkStockDfList = Objects.requireNonNull(JSONArray.parseArray(diff, AllHkStockDf.class));
        return hkStockDfList;
    }
}
