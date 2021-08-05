package com.polofox.http.header.date;

import lombok.Data;

import java.io.Serializable;
@Data
public class Date<T> implements Serializable {
    /*报文创建时间*/
    T date;
}
