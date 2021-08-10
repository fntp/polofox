package com.polofox.http.header.accept;

import lombok.Data;

import java.io.Serializable;
@Data
public class Accept_Encoding<T> implements Serializable {
    /*指定浏览器可以支持的web服务器返回内容压缩编码类型*/
    T accept_Encoding;
}
