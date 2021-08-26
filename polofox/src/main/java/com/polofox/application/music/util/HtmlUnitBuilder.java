package com.polofox.application.music.util;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Write By SunChengXin
 * @title: HtmlUnitBuilder
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/25-16:13
 */
@Data
public class HtmlUnitBuilder {
    /**
     * 请求URL
     */
    private String url;
    /**
     * 代理服务器地址
     */
    private String proxyHost;
    /**
     * 代理服务器端口
     */
    private int proxyPort;
    /**
     * 代理服务器账户
     */
    private String username;
    /**
     * 代理服务器密码
     */
    private String password;
    /**
     * CSS支持
     */
    private boolean enableCSS = false;
    /**
     * JavaScript支持
     */
    private boolean enableJS = false;
    /**
     * Ajax支持
     */
    private boolean enableAjax = false;
    /**
     * cookie支持
     */
    private boolean enableCookie = false;
    /**
     * 等待JS加载时间
     */
    private int waitForBackgroundJavaScript = 0;
    /**
     * 请求异常重试次数
     */
    private int retry = 0;
    /**
     * 请求头参数
     */
    private Map<String, String> headers = new HashMap<>();
    /**
     * cookie不是必须的 但绝对会用到
     */
    private Map<String, String> cookies = new HashMap<>();


    public static HtmlUnitBuilder config() {
        return new HtmlUnitBuilder();
    }

    public HtmlUnitBuilder url(String url) {
        this.url = url;
        return this;
    }

    public HtmlUnitBuilder retry(int retry) {
        this.retry = retry;
        return this;
    }

    /**
     * 不需要验证的代理服务器
     *
     * @param proxyHost
     * @param proxyPort
     * @return
     */
    public HtmlUnitBuilder proxy(String proxyHost, int proxyPort) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        return this;
    }

    /**
     * 需要验证的代理服务器
     *
     * @param proxyHost
     * @param proxyPort
     * @param username
     * @param password
     * @return
     */
    public HtmlUnitBuilder proxy(String proxyHost, int proxyPort,
                                 String username, String password) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.username = username;
        this.password = password;
        return this;
    }

    public HtmlUnitBuilder enableCSS(boolean enableCSS) {
        this.enableCSS = enableCSS;
        return this;
    }

    public HtmlUnitBuilder enableJS(boolean enableJS) {
        this.enableJS = enableJS;
        return this;
    }

    public HtmlUnitBuilder enableAjax(boolean enableAjax) {
        this.enableAjax = enableAjax;
        return this;
    }

    public HtmlUnitBuilder enableCookie(boolean enableCookie) {
        this.enableCookie = enableCookie;
        return this;
    }

    public HtmlUnitBuilder cookies(Map<String, String> cookies){
        this.cookies = cookies;
        return this;
    }



    /**
     * 设置新的请求头集合
     *
     * @param headers
     * @return
     */
    public HtmlUnitBuilder headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * 添加请求头参数
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public HtmlUnitBuilder addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public HtmlUnitBuilder waitForBackgroundJavaScript(int waitForBackgroundJavaScript) {
        this.waitForBackgroundJavaScript = waitForBackgroundJavaScript;
        return this;
    }

    public String url() {
        return url;
    }

    public int retry() {
        return retry;
    }

    public String proxyHost() {
        return proxyHost;
    }

    public int proxyPort() {
        return proxyPort;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public boolean enableCSS() {
        return enableCSS;
    }

    public boolean enableJS() {
        return enableJS;
    }

    public boolean enableAjax() {
        return enableAjax;
    }

    public boolean enableCookie() {
        return enableCookie;
    }

    public int waitForBackgroundJavaScript() {
        return waitForBackgroundJavaScript;
    }

    public Map<String, String> headers() {
        return headers;
    }
    public Map<String,String> cookies(){
        return cookies;
    }
}


