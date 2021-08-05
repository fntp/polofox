package com.polofox.http.header.maxforward;

import lombok.Data;

import java.io.Serializable;
@Data
public class Max_Forwards<T> implements Serializable {
    /*限制该消息可被代理及网关转发的次数*/
    T max_Forwards;
}
