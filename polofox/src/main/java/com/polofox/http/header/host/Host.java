package com.polofox.http.header.host;
import lombok.Data;
import java.io.Serializable;
@Data
public class Host<T> implements Serializable {

    /* Host主机的IP地址Address IP地址 */
    T ipAddress;

    /* Host主机的端口 */
    T port;

    /* Host主机的mac地址 */
    T macAddress;

    /* Host主机的区域属性：（1）本地Local （2）远程Remote */
    T attribute;
}
