package com.polofox.http.header.cookie;
import lombok.Data;
import java.io.Serializable;
@Data
public class Cookie<T> implements Serializable {
    /*cookie的内容 暂时不做二次封装*/
    T content;
}
