package com.polofox.http.header.cache;
import lombok.Data;
import java.io.Serializable;
@Data
public class Cache_Control<T> implements Serializable {

    /*指定请求和响应遵循的缓存机制  用来指定当前的请求/回复中是否使用缓存机制*/
    T cache_control;
}
