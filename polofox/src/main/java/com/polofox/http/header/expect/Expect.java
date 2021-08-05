package com.polofox.http.header.expect;

import lombok.Data;

import java.io.Serializable;
@Data
public class Expect<T> implements Serializable {
    /*表示客户端要求服务器做出特定的行为*/
    T expect;
}
