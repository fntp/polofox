package com.polofox.http.header.ReqHeader.accept;
import lombok.Data;
import java.io.Serializable;
@Data
public class Accept<T> implements Serializable {

    /*浏览器可以接受的字符编码集。*/
    T accept_Charset;

    /*指定浏览器可以支持的web服务器返回内容压缩编码类型*/
    T accept_Encoding;

    /*浏览器可接受的语言*/
    T accept_Language;

    /*可以请求网页实体的一个或者多个子范围字段*/
    T accept_Ranges;
}
