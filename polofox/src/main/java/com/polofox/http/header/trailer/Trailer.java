package com.polofox.http.header.trailer;

import java.io.Serializable;

public class Trailer<T> implements Serializable {
    /*会实现说明在报文主体后记录哪些首部字段，该首部字段可以使用在 HTTP/1.1 版本分块传输编码时*/
    T trailer;
}
