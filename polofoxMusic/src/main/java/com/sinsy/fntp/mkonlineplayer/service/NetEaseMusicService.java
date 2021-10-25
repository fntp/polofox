package com.sinsy.fntp.mkonlineplayer.service;

import com.sinsy.fntp.mkonlineplayer.bean.NetEaseMusic;

import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: NetEaseMusicService
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/10/22-13:05
 */
public interface NetEaseMusicService {
    /**
     * 获得网易云音乐的音乐列表
     * @param musicName 音乐名称
     * @return 返回的是一个音乐列表
     */
    List<NetEaseMusic> getNetEaseMusicListByMusicName(String musicName);
}
