package com.polofox.http.header;

import com.polofox.http.header.cache.Cache_Control;
import com.polofox.http.header.connection.Connection;
import com.polofox.http.header.date.Date;
import com.polofox.http.header.trailer.Trailer;
import com.polofox.http.header.transferencoding.Transfer_Encoding;
import com.polofox.http.header.upgrade.Upgrade;
import com.polofox.http.header.via.Via;
import com.polofox.http.header.warning.Warning;
import lombok.Data;

/**
 * @HttpHeader
 * 2020/08/06 通用Http协议头的数据结构封装
 * 仅仅只有Header部分的数据封装
 */
@Data
public abstract class Header<T> {
    private Cache_Control<String> cache_control;
    private Connection<String> connection;
    private Date<String> date;
    private Trailer<String> trailer;
    private Transfer_Encoding<String> transfer_encoding;
    private Upgrade<String> upgrade;
    private Via<String> via;
    private Warning<String> warning;
}
