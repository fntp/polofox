package com.polofox;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Write By SunChengXin
 * @title: Test
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/11/4-12:44
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
}
