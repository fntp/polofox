package com.polofox.http.header.warning;

import lombok.Data;

import java.io.Serializable;
@Data
public class Warning<T> implements Serializable {
    /*一个一般性的警告，表示在实体内容中可能存在错误*/
    T warning;
}
