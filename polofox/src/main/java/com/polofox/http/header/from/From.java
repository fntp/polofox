package com.polofox.http.header.from;

import lombok.Data;

import java.io.Serializable;
@Data
public class From<T> implements Serializable {
    /*发起此请求的用户的邮件地址*/
    T from;
}
