package com.sinsy.fntp.mkonlineplayer.test.TestMusic;

import com.polofox.log.Log;
import com.sinsy.fntp.mkonlineplayer.bean.NetEaseMusic;
import com.sinsy.fntp.mkonlineplayer.service.NetEaseMusicService;
import com.sinsy.fntp.mkonlineplayer.service.impl.NetEaseMusicServiceImpl;

import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: Test
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/10/22-13:49
 */
public class Test {
    public static void main(String[] args) {
        try {
            Log.info();
            NetEaseMusicService service = new NetEaseMusicServiceImpl();
            List<NetEaseMusic> list = service.getNetEaseMusicListByMusicName("我不对");
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
