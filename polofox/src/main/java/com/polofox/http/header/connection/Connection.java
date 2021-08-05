package com.polofox.http.header.connection;
import lombok.Data;
import java.io.Serializable;
@Data
public class Connection<T> implements Serializable {
    /* 表示是否需要持久连接。（HTTP 1.1默认进行持久连接）客户端（浏览器）想要优先使用的连接类型 */
    T  connection;
}
