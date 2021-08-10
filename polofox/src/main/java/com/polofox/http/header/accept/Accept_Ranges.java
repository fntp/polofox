package com.polofox.http.header.accept;

import lombok.Data;

import java.io.Serializable;
@Data
public class Accept_Ranges<T> implements Serializable {
    /*可以请求网页实体的一个或者多个子范围字段*/
    T accept_Ranges;
}
