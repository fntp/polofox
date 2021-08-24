package com.polofox.application.music.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Music implements Serializable {

    private String artist;

    private String id;

    private boolean is_licensed;

    private String title;

    private String url;

    private JSON album;

    private String access_key;

    public Music() {

    }

    public Music(String artist, String id, boolean is_licensed, String title, String url, JSON album, String access_key) {
        this.artist = artist;
        this.id = id;
        this.is_licensed = is_licensed;
        this.title = title;
        this.url = url;
        this.album = album;
        this.access_key = access_key;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_licensed() {
        return is_licensed;
    }

    public void setIs_licensed(boolean is_licensed) {
        this.is_licensed = is_licensed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSON getAlbum() {
        return album;
    }

    public void setAlbum(JSON album) {
        this.album = album;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    @Override
    public String toString() {
        return "Music{" +
                "artist='" + artist + '\'' +
                ", id='" + id + '\'' +
                ", is_licensed=" + is_licensed +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", album=" + album.toJSONString() +
                ", access_key='" + access_key + '\'' +
                '}';
    }

}
