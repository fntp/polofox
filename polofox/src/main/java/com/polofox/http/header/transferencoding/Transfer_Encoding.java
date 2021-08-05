package com.polofox.http.header.transferencoding;

import lombok.Data;

import java.io.Serializable;
@Data
public class Transfer_Encoding<T> implements Serializable {
    T transfer_Encoding;
}
