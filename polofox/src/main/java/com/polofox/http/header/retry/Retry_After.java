package com.polofox.http.header.retry;

import com.polofox.log.Info;
import lombok.Data;

import java.io.Serializable;
@Data
public class Retry_After<T> implements Serializable {
        @Info(info = "告知客户端多久后再发送请求" )
        T retry_After;
}
