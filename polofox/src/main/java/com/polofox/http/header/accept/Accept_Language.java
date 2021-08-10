package com.polofox.http.header.accept;

import lombok.Data;

import java.io.Serializable;
@Data
public class Accept_Language<T> implements Serializable {
    /*浏览器可接受的语言*/
    T accept_Language;
}
