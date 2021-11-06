package com.polofox.application.exchange;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Write By SunChengXin
 * @title: ExchangeRate
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/11/4-13:02
 */
@Data
@Setter
@Getter
@ToString
public class ExchangeRate implements Serializable {
    private static final long serialVersionUID = -7120069128057696145L;
    private String from;
    private String to;
    private String exchangeRate;

}
