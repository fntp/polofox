package com.polofox.http.header.upgrade;

import lombok.Data;

import java.io.Serializable;
@Data
public class Upgrade<T> implements Serializable {
    T upgrade;
}
