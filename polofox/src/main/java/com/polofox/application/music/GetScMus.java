package com.polofox.application.music;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.polofox.application.music.bean.ScMusic;
import com.polofox.application.music.util.HttpReq;

import java.io.IOException;
import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: GetScMus
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/9/26-14:27
 */
public class GetScMus {
    public static void main(String[] args) {
        getList();
        getString("java.lang.Scx");
    }
    public static void getList(){
        String url = "http://music.dwh99.cn/api/search/?name=周杰伦&page=1";
        try {
            String json = HttpReq.getJson(url);
            JSONObject objects = JSONObject.parseObject(json);
            String string = objects.getString("data");
            List<ScMusic> scMusics = JSONArray.parseArray(string, ScMusic.class);
            scMusics.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getString(String name){
        Class<?> aClass = null;
        try {
            aClass = Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass.getName());
    }
}
