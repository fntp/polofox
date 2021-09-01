package com.polofox.application.stock.eastmoney.service.impl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.polofox.application.stock.eastmoney.bean.AllHkStockDf;
import com.polofox.application.stock.eastmoney.bean.Comment;
import com.polofox.application.stock.eastmoney.bean.UserInfo;
import com.polofox.application.stock.eastmoney.httpreq.EastHttpReq;
import com.polofox.application.stock.eastmoney.service.ListService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

/**
 * @author Write By SunChengXin
 * @title: ListServiceImpl
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-18:09
 */
@Service
public class ListServiceImpl implements ListService {

    @Override
    public List<AllHkStockDf> getHkStockDfList(String url) {
        // 第一步 拿到Document
        String jsonStr = "";
        try {
            jsonStr = EastHttpReq.getJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第二步 转成JsonList
        JSONObject responseJson;
        responseJson = JSONObject.parseObject(jsonStr);
        JSONObject object = responseJson.getJSONObject("data");
        String diff = object.getString("diff");
        return Objects.requireNonNull(JSONArray.parseArray(diff, AllHkStockDf.class));
    }

    @Override
    public List<Comment> getHkStockDfCommentList(String url) {
        // 第一步 拿到Document
        String jsonStr = "";
        try {
            jsonStr = EastHttpReq.getJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第二步 转成JsonList
        JSONObject responseJson;
        responseJson = JSONObject.parseObject(jsonStr);
        JSONArray object = responseJson.getJSONArray("re");
        String result = object.toJSONString();
        return Objects.requireNonNull(JSONArray.parseArray(result, Comment.class));
    }

    /**
     * 其实这里三个方法可以进行代码抽取，暂时先不写写一个TODO标记一下
     * TODO 代码抽取相同部分
     * @param url 请求地址
     * @return 返回一个列表
     */
    @Override
    public List<UserInfo> getUserInfoList(String url) {
        // 第一步 拿到Document
        String jsonStr = "";
        try {
            jsonStr = EastHttpReq.getJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第二步 转成JsonList
        JSONObject responseJson;
        responseJson = JSONObject.parseObject(jsonStr);
        JSONObject object = responseJson.getJSONObject("result");
        String result = object.toJSONString();
        return Objects.requireNonNull(JSONArray.parseArray(result, UserInfo.class));
    }

    @Override
    public List<AllHkStockDf> getUserSFollowQuoteList(String url) {
        // 第一步 获得document网页文档
        Document document = EastHttpReq.getDocument(url, EastHttpReq.setHeaders());
        // 第二步 获得数据
        assert document != null;
        Element tbody = document.select("[class=secontent]").get(0).child(1);
        for (int i = 0; i < tbody.childNodeSize(); i++) {
            for (int j = 0; j < tbody.select("td").size(); j++) {

            }
        }
        return null;
    }
}
