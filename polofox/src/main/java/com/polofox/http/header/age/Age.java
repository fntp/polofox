package com.polofox.http.header.age;

import lombok.Data;

import java.io.Serializable;
@Data
public class Age<T> implements Serializable {
    /* 创建响应的时间 */
    T age;
}
