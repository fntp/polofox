package com.polofox.http.header.condition;
import lombok.Data;
import java.io.Serializable;
@Data
public class If<T> implements Serializable {
    /* 只有请求内容与实体相匹配才有效 */
    T if_Match;
    /*如果请求的部分在指定时间之后被修改则请求成功，未被修改则返回304代码*/
    T if_Modified_Since;
    /*如果内容未改变返回304代码，参数为服务器先前发送的Etag，与服务器回应的Etag比较判断是否改变*/
    T if_None_Match;
    /*如果实体未改变，服务器发送客户端丢失的部分，否则发送整个实体。参数也为Etag*/
    T if_Range;
    /*只在实体在指定时间之后未被修改才请求成功*/
    T if_UnModified_Since;
}
