package com.polofox.http.header.accept;

import lombok.Data;

import java.io.Serializable;
@Data
public class Accept_Charset<T> implements Serializable {
    /*浏览器可以接受的字符编码集。*/
    T accept_Charset;
}
