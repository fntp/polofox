package com.polofox.http.header.location;

import lombok.Data;

import java.io.Serializable;
@Data
public class Location<T> implements Serializable {
    /* 表示重定向后的 URL */
    T location;
}
