package com.polofox.application.stock.eastmoney.httpreq;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.polofox.application.stock.eastmoney.bean.UserInfo;
import com.polofox.log.Info;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 封装请求信息
 * @author Write By SunChengXin
 * @title: HttpReq http请求
 * @projectName polofox polofox爬虫
 * @Modifier: SunChengXin @fntp
 * @date 2021/8/27-17:39
 */
public class EastHttpReq {

    @Info(info = "jsoup提供的第三方的连接")
    private static Connection connection;

    /**
     * 设置请求头
     * @return 返回一个hashMap
     */
    @Info(info = "在这里设置请求头信息")
    public static Map<String,String> setHeaders(){
        Map<String,String> headerMap = new LinkedHashMap<>();
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        headerMap.put("Cookie", "nts_mail_user=stickpoint@163.com:-1:1; _iuqxldmzr_=32; _ntes_nnid=b49621477869026d8f2893ae6245e6ca,1617787746798; _ntes_nuid=b49621477869026d8f2893ae6245e6ca; NMTID=00ObXGNe6f1I-KkwkFWnO_7sTlGY68AAAF4q6n_JQ; WM_TID=AF2215MJFaVBQUUBAUY%2BwI3fmN1RED6F; P_INFO=mysinsy@163.com|1617787767|0|mail163|00&99|hlj&1617699533&carddav#hlj&230600#10#0#0|&0|youdao_zhiyun2018&mail163|mysinsy@163.com; pver_n_f_l_n3=a; vinfo_n_f_l_n3=255d04cb1a59be57.1.0.1619616177348.0.1619616199659; JSESSIONID-WYYY=E5TA%2Bd3SvayzS%5Ca2M%5CKZxqgy3%5CjlbTlKo8yDD7cr3PP7xegkxygJoi%2FGE%2BQzJZxBH6lVl6%5CSyMEVdO4RAjSMZ1YXdgWv4vwkKgBCtYbVHOuwR%5CfY%5C58kQorsaD89tWr3Wb8Np%5C%2B%5CdsbvQ%2FwGZIPkBYRvAJCXFPsB0slUvoJeW3HresV0%3A1620051123573; WEVNSM=1.0.0; WM_NI=YSmXQ%2FIohuG62lg6v%2BExREPzBjtfl3AnvGCF724VYlIpF3quDjzOb%2F4pPmwW5SVjBOSEUqfQ%2BPwmPjv2K9gblnjiEpXJVaQM%2Fo1QcuWIA0OhYi6ZONlix%2BaRvPhSt7rncU0%3D; WM_NIKE=9ca17ae2e6ffcda170e2e6ee9af025a39396d6cf5a8cb08ab2d15e869a8f84f57db5b187b0b139f68da584c92af0fea7c3b92a9b8da3b9d4258bb1a896c63ef2b4a9d7f52187a89ea6d37282b6bc87ef3983b2baa8c24ef5eefcb7dc688bb08ad4f47f88b6b6b0e125f8b0a08ef65df78d9a8bc145919b9b92e55be990b98ed362b6ee85dae66ab0b2a68ac87c9c969a82d447edb1ffb2e27f95978fd1ce649bb7fabbce46b0b7b8cce45ab690a8b4f73db2b2adb6b337e2a3; __csrf=d29f199b16fe492a7a177cccf6e94cc1; __remember_me=true; MUSIC_U=bd490159dfb5062a7295e6816e93836a05947b73657916bb1c7677a3a66d938433a649814e309366; ntes_kaola_ad=1");
        return headerMap;
    }

    /**
     * 特殊请求头
     * @return 返回一个HashMap
     */
    @Info(info = "封装特殊请求头")
    public static Map<String,String> setUniversalHeaders(){
        Map<String,String> headerMap = new LinkedHashMap<>();
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        return headerMap;
    }

    /**
     * 返回一个链接，带有常规header请求头的链接
     * @param url 请求地址
     * @param headerMap 请求头
     * @return jsoup封装的连接
     */
    @Info(info = "封装请求头信息使用HashMap")
    public static Connection getConnection(String url,Map<String,String> headerMap) {
        connection = Jsoup.connect(url);
        connection.headers(headerMap);
        return connection;
    }

    /**
     * 返回一个链接，带有特殊header请求头的链接
     * @param url 请求地址
     * @param headerMap 请求头
     * @return jsoup封装的连接
     */
    public static Connection getConnectionUniversal(String url,Map<String,String> headerMap){
        connection = Jsoup.connect(url);
        connection.headers(headerMap);
        return connection;
    }


    /**
     * 返回请求地址之后的常规文档Document
     * @param url 请求地址
     * @param headerMap 请求头
     * @return 返回一个常规化的文档
     */
    public static Document getDocument (String url,Map<String,String> headerMap){
        try {
            return getConnection(url,headerMap).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回请求地址之后的特殊文档Document
     * @param url 请求地址
     * @param headerMap 请求头
     * @return 返回一个特殊化的文档
     */
    public static Document getUniversalDocument (String url,Map<String,String> headerMap){
        try {
            return getConnectionUniversal(url,headerMap).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得JSON的服务（基础请求仍然是通过Jsoup发起的请求）
     * 默认超时 10000s
     * @param reqUrl 请求地址
     * @return 返回的是JSON体，除非你请求的是接口，否则不建议调用此方法
     * @throws IOException 排除IO异常
     */
    @Info(info = "除非你调用的是接口直接返回的是JSON，否则不建议使用此方法")
    public static String getJson(String reqUrl) throws IOException {
        Connection.Response res = Jsoup.connect(reqUrl)
                .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true).execute();
        String json = "";
        json=res.body();
        return json;
    }

    /**
     * 获得JSON的服务（基础请求仍然是通过Jsoup发起的请求）
     * 默认超时 10000s
     * @param reqUrl 请求地址
     * @param headerMap 请求头
     * @return 返回的是JSON体，除非你请求的是接口，否则不建议调用此方法
     * @throws IOException 排除IO异常
     */
    @Info(info = "除非你调用的是接口直接返回的是JSON，否则不建议使用此方法")
    public static String getJsonUniversal(String reqUrl,Map<String,String> headerMap) throws IOException {
        Connection.Response res = getConnectionUniversal(reqUrl, headerMap)
                .timeout(10000).ignoreContentType(true).execute();
        String json = "";
        json=res.body();
        return json;
    }

    /**
     * 传入一个字符串，这个字符串代表着一个网页，说白了就是你需要传入一个网页toString后的字符串
     * 然后会给你返回一个基于Jsoup封装好的本地Document，无header信息。使用的场景范围比较狭窄。
     * @param responseStr 传入一个网页toString()后的字符串结果
     * @return 返回自动转换后的文档
     */
    public static Document parseResponse(String responseStr){
        Document doc=Jsoup.parse(responseStr);
        return doc;
    }

    public static List getObjectList(String url,String targetJsonKeyName,Class obj){
        // 第一步 拿到Document
        String jsonStr = "";
        try {
            jsonStr = getJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第二步 转成JsonList
        JSONObject responseJson;
        responseJson = JSONObject.parseObject(jsonStr);
        JSONObject object = responseJson.getJSONObject(targetJsonKeyName);
        String result = object.toJSONString();
        return Objects.requireNonNull(JSONArray.parseArray(result, obj));
    }
}
