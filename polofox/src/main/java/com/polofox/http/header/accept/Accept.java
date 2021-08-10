package com.polofox.http.header.accept;
import lombok.Data;
import java.io.Serializable;
@Data
public class Accept<T> implements Serializable {
    T accept;
}
