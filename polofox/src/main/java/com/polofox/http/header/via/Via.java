package com.polofox.http.header.via;
import lombok.Data;
import java.io.Serializable;
@Data
public class Via<T> implements Serializable {
        T via;
}
