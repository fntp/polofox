package com.sinsy.fntp.mkonlineplayer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.polofox.application.music.util.HttpReq;
import com.sinsy.fntp.mkonlineplayer.bean.NetEaseMusic;
import com.sinsy.fntp.mkonlineplayer.service.NetEaseMusicService;
import com.sinsy.fntp.mkonlineplayer.utils.LocalStringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Write By SunChengXin
 * @title: NetEaseMusicServiceImpl
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/10/22-13:09
 */
@Slf4j
public class NetEaseMusicServiceImpl implements NetEaseMusicService {
    /**
     * 获得网易云音乐的音乐列表
     * @param musicName 音乐名称
     * @return 返回的是一个音乐列表
     */
    @Override
    public List<NetEaseMusic> getNetEaseMusicListByMusicName(String musicName) {
        String baseUrl = LocalStringUtils.getLocalProperties("server1.properties", "BaseUrl");
        Map<String,String> localDataMap = new LinkedHashMap<>();
        localDataMap.put("source","netease");
        localDataMap.put("pages","1");
        localDataMap.put("count","20");
        localDataMap.put("types","search");
        localDataMap.put("name",musicName);
        String andUrl = LocalStringUtils.getAndUrl(baseUrl,localDataMap);
        try {
            log.info("请求的地址是{}",andUrl);
            System.out.println("请求的地址是"+andUrl);
            System.out.println("请求的地址是"+baseUrl);
            String json = HttpReq.getJson(andUrl);
            List<NetEaseMusic> netEaseMusicList = JSONObject.parseArray(json, NetEaseMusic.class);
            if (Objects.isNull(netEaseMusicList)) {
                throw new NullPointerException("空指针");
            }else {
                return netEaseMusicList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
