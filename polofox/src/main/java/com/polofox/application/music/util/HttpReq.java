package com.polofox.application.music.util;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.DefaultJavaScriptErrorListener;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
/***
   * @Coder scx
　　* @description: 基本请求信息
　　* @author SunChengXin
　　* @date 2021/8/25 16:21
　　*/
public class HttpReq {

    private Connection connection;

    private static Map<String,String> headerMap;

    private static WebClient webClient;

    /**
     * 有代理的web浏览器抓取的Client客户端
     * 默认为谷歌浏览器
     * @param hostIpAddress 主机IP地址
     * @param hostPort 主机端口
     * @return 返回一个WebClient
     */
    public static WebClient getReadyWebClient(String hostIpAddress,int hostPort){
        //设置本地代理
        webClient = new WebClient(BrowserVersion.CHROME, hostIpAddress, hostPort);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);
        // 保留 JavaScript支持 ✔
        webClient.getOptions().setJavaScriptEnabled(true);
        //是否使用不安全的SSL
        webClient.getOptions().setUseInsecureSSL(true);
        //状态码错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);
        //等待js时间
        webClient.waitForBackgroundJavaScript(60*1000);
        //设置超时时间
        webClient.getOptions().setTimeout(65000);
        //直接返回
        return webClient;
    }

    /**
     * TODO：方法的重载，返回没有参数的默认浏览器客户端
     * TODO：默认为谷歌浏览器
     * @return
     */
    public static WebClient getReadyWebClient(){
//        webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener
        webClient = new WebClient(BrowserVersion.FIREFOX_78);
//        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);
        // 保留 JavaScript支持 ✔
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setJavaScriptErrorListener(new MyJSErrorListener());
        webClient.getOptions().setJavaScriptEnabled(true);
        //禁止抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);
//        //是否使用不安全的SSL
        webClient.getOptions().setUseInsecureSSL(true);
        //支持ajax
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        //等待js时间
        webClient.waitForBackgroundJavaScript(5000);
        //设置超时时间
        webClient.getOptions().setTimeout(5000);

        //直接返回
        return webClient;
    }

    public static Document getDocumentByBro(String reqUrl) throws Exception{
        WebClient wc = new WebClient(BrowserVersion.CHROME);
        //是否使用不安全的SSL
        wc.getOptions().setUseInsecureSSL(true);
        //启用JS解释器，默认为true
        wc.getOptions().setJavaScriptEnabled(true);
        //禁用CSS
        wc.getOptions().setCssEnabled(false);
        //js运行错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnScriptError(false);
        wc.setJavaScriptErrorListener(new MyJSErrorListener());
        //状态码错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnFailingStatusCode(true);
        //是否允许使用ActiveX
        wc.getOptions().setActiveXNative(false);
        //等待js时间
        wc.waitForBackgroundJavaScript(600*1000);
        //设置Ajax异步处理控制器即启用Ajax支持
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        //设置超时时间
        wc.getOptions().setTimeout(10000);
        //不跟踪抓取
        wc.getOptions().setDoNotTrackEnabled(false);
        WebRequest request=new WebRequest(new URL(reqUrl));
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:62.0) Gecko/20100101 Firefox/62.0");
        try {
            //模拟浏览器打开一个目标网址
            HtmlPage htmlPage = wc. getPage(request);
            //为了获取js执行的数据 线程开始沉睡等待
            Thread.sleep(1000);
            //这个线程的等待 因为js加载需要时间的
            //以xml形式获取响应文本
            String xml = htmlPage.asXml();
            //并转为Document对象return
            return Jsoup.parse(xml);
            //System.out.println(xml.contains("结果.xls"));//false
        } catch (FailingHttpStatusCodeException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String,String> setHeaders(){
        headerMap = new LinkedHashMap<> ();
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        headerMap.put("Cookie", "nts_mail_user=stickpoint@163.com:-1:1; _iuqxldmzr_=32; _ntes_nnid=b49621477869026d8f2893ae6245e6ca,1617787746798; _ntes_nuid=b49621477869026d8f2893ae6245e6ca; NMTID=00ObXGNe6f1I-KkwkFWnO_7sTlGY68AAAF4q6n_JQ; WM_TID=AF2215MJFaVBQUUBAUY%2BwI3fmN1RED6F; P_INFO=mysinsy@163.com|1617787767|0|mail163|00&99|hlj&1617699533&carddav#hlj&230600#10#0#0|&0|youdao_zhiyun2018&mail163|mysinsy@163.com; pver_n_f_l_n3=a; vinfo_n_f_l_n3=255d04cb1a59be57.1.0.1619616177348.0.1619616199659; JSESSIONID-WYYY=E5TA%2Bd3SvayzS%5Ca2M%5CKZxqgy3%5CjlbTlKo8yDD7cr3PP7xegkxygJoi%2FGE%2BQzJZxBH6lVl6%5CSyMEVdO4RAjSMZ1YXdgWv4vwkKgBCtYbVHOuwR%5CfY%5C58kQorsaD89tWr3Wb8Np%5C%2B%5CdsbvQ%2FwGZIPkBYRvAJCXFPsB0slUvoJeW3HresV0%3A1620051123573; WEVNSM=1.0.0; WM_NI=YSmXQ%2FIohuG62lg6v%2BExREPzBjtfl3AnvGCF724VYlIpF3quDjzOb%2F4pPmwW5SVjBOSEUqfQ%2BPwmPjv2K9gblnjiEpXJVaQM%2Fo1QcuWIA0OhYi6ZONlix%2BaRvPhSt7rncU0%3D; WM_NIKE=9ca17ae2e6ffcda170e2e6ee9af025a39396d6cf5a8cb08ab2d15e869a8f84f57db5b187b0b139f68da584c92af0fea7c3b92a9b8da3b9d4258bb1a896c63ef2b4a9d7f52187a89ea6d37282b6bc87ef3983b2baa8c24ef5eefcb7dc688bb08ad4f47f88b6b6b0e125f8b0a08ef65df78d9a8bc145919b9b92e55be990b98ed362b6ee85dae66ab0b2a68ac87c9c969a82d447edb1ffb2e27f95978fd1ce649bb7fabbce46b0b7b8cce45ab690a8b4f73db2b2adb6b337e2a3; __csrf=d29f199b16fe492a7a177cccf6e94cc1; __remember_me=true; MUSIC_U=bd490159dfb5062a7295e6816e93836a05947b73657916bb1c7677a3a66d938433a649814e309366; ntes_kaola_ad=1");
        return headerMap;
    }

    public static Map<String,String> universalHeaders(){
        headerMap = new LinkedHashMap<> ();
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        return headerMap;
    }
    /**
     * 返回一个链接，带有header请求头的链接
     * @param url
     * @return
     */
    public Connection getConnection(String url) {
        connection = Jsoup.connect(url);
        connection.headers(setHeaders());
        return connection;
    }

    public Connection getConnectionUniversal(String url){
        connection = Jsoup.connect(url);
        connection.headers(universalHeaders());
        return connection;
    }
    /**
     * 返回请求地址之后的文档Document
     * @param url
     * @return
     */
    public Document getDocument (String url){
        try {
            return getConnection(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Document getDocUniversal (String url){
        try {
            return getConnectionUniversal(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJson(String reqUrl) throws IOException {
        Response res = Jsoup.connect(reqUrl)
                .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true).execute();
        String json = "";
        json=res.body();
    return json;
    }

    /**
     *TODO:给出本地的html页面，然后调用Jsoup解析本地Html返回解析后的Document节点
     * @param responseStr
     * @return
     */
    public static Document parseResponse(String responseStr){
        Document doc=Jsoup.parse(responseStr);
        return doc;
    }
    public static class MyJSErrorListener extends DefaultJavaScriptErrorListener {
        @Override
        public void scriptException(HtmlPage page, ScriptException scriptException) {
        }

        @Override
        public void timeoutError(HtmlPage page, long allowedTime, long executionTime) {
        }

        @Override
        public void malformedScriptURL(HtmlPage page, String url, MalformedURLException malformedURLException) {

        }

        @Override
        public void loadScriptError(HtmlPage page, URL scriptUrl, Exception exception) {

        }

        @Override
        public void warn(String message, String sourceName, int line, String lineSource, int lineOffset) {

        }
    }
}
