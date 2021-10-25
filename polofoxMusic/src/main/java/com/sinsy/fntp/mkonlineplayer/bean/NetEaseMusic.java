package com.sinsy.fntp.mkonlineplayer.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: Music
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/10/22-12:56
 */
@Data
@Setter
@Getter
@ToString
public class NetEaseMusic{

    private int id;

    private String name;

    private List<String> artist ;

    private String album;

    private String picId;

    private int urlId;

    private int lyricId;

    private String source;

}