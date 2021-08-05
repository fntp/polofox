package com.polofox.http.header.authorization;

import lombok.Data;

import java.io.Serializable;
@Data
public class Authorization<T> implements Serializable {
    T authorization;
}
