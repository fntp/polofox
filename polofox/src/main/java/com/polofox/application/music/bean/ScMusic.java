package com.polofox.application.music.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Write By SunChengXin
 * @title: ScMusic
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/9/26-11:52
 */
@Data
@Setter
@Getter
@ToString
public class ScMusic implements Serializable {

    private static final long serialVersionUID = 209831661763519653L;
    /**
     * 演唱者
     */
    private String people;
    /**
     * 歌曲名字
     */
    private String music;
    /**
     * url的Id
     */
    private String url;
    /**
     * rid
     */
    private String rid;
    /**
     * 歌曲时间
     */
    private String songTime;
    /**
     * 专辑
     */
    private String album;
}
