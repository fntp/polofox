package com.polofox.http.header.eTag;

import lombok.Data;

import java.io.Serializable;
@Data
public class ETag<T> implements Serializable {
    /* 唯一标识分配的资源 */
    T etag;
}
