package com.polofox.utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author Write By SunChengXin
 * @title: BeanUtils
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/9/24-19:49
 */
public class BeanUtils {

    public static void main(String[] args) {
        String str = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"晴天\",\n" +
                "            \"url\": 228908,\n" +
                "            \"rid\": 228908,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"叶惠美\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"稻香\",\n" +
                "            \"url\": 440613,\n" +
                "            \"rid\": 440613,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"魔杰座\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"青花瓷\",\n" +
                "            \"url\": 324244,\n" +
                "            \"rid\": 324244,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"我很忙\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"花海\",\n" +
                "            \"url\": 440615,\n" +
                "            \"rid\": 440615,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"魔杰座\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"夜曲\",\n" +
                "            \"url\": 118980,\n" +
                "            \"rid\": 118980,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"十一月的萧邦\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"给我一首歌的时间\",\n" +
                "            \"url\": 440614,\n" +
                "            \"rid\": 440614,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"魔杰座\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"七里香\",\n" +
                "            \"url\": 94237,\n" +
                "            \"rid\": 94237,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"七里香\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"告白气球\",\n" +
                "            \"url\": 7149583,\n" +
                "            \"rid\": 7149583,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"周杰伦的床边故事\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"一路向北-《头文字D》电影插曲\",\n" +
                "            \"url\": 6871880,\n" +
                "            \"rid\": 6871880,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"J&nbsp;III&nbsp;MP3&nbsp;Player\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"霍元甲-《霍元甲》电影主题曲|《这！就是街舞》第四期背景音乐\",\n" +
                "            \"url\": 268702,\n" +
                "            \"rid\": 268702,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"霍元甲\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"明明就\",\n" +
                "            \"url\": 3197116,\n" +
                "            \"rid\": 3197116,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"十二新作\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"兰亭序\",\n" +
                "            \"url\": 440616,\n" +
                "            \"rid\": 440616,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"魔杰座\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦&潘儿\",\n" +
                "            \"music\": \"夜的第七章\",\n" +
                "            \"url\": 228907,\n" +
                "            \"rid\": 228907,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"依然范特西\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"我是如此相信-《天火》电影主题曲\",\n" +
                "            \"url\": 83728113,\n" +
                "            \"rid\": 83728113,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"我是如此相信\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"听妈妈的话\",\n" +
                "            \"url\": 138243,\n" +
                "            \"rid\": 138243,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"依然范特西\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"以父之名\",\n" +
                "            \"url\": 238210,\n" +
                "            \"rid\": 238210,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"叶惠美\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦&林俊杰\",\n" +
                "            \"music\": \"稻香\",\n" +
                "            \"url\": 140064959,\n" +
                "            \"rid\": 140064959,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"简单爱\",\n" +
                "            \"url\": 156522,\n" +
                "            \"rid\": 156522,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"范特西\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"搁浅\",\n" +
                "            \"url\": 94239,\n" +
                "            \"rid\": 94239,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"七里香\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"发如雪\",\n" +
                "            \"url\": 118990,\n" +
                "            \"rid\": 118990,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"十一月的萧邦\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"蒲公英的约定\",\n" +
                "            \"url\": 324243,\n" +
                "            \"rid\": 324243,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"我很忙\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"反方向的钟\",\n" +
                "            \"url\": 215257,\n" +
                "            \"rid\": 215257,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"Jay\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"等你下课(with&nbsp;杨瑞代)\",\n" +
                "            \"url\": 40079875,\n" +
                "            \"rid\": 40079875,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"等你下课\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"烟花易冷\",\n" +
                "            \"url\": 728677,\n" +
                "            \"rid\": 728677,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"跨时代\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"青花瓷\",\n" +
                "            \"url\": 77005852,\n" +
                "            \"rid\": 77005852,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"东风破\",\n" +
                "            \"url\": 79479,\n" +
                "            \"rid\": 79479,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"叶惠美\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"枫\",\n" +
                "            \"url\": 118987,\n" +
                "            \"rid\": 118987,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"十一月的萧邦\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"半岛铁盒\",\n" +
                "            \"url\": 235498,\n" +
                "            \"rid\": 235498,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"八度空间\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"本草纲目\",\n" +
                "            \"url\": 228912,\n" +
                "            \"rid\": 228912,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"依然范特西\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"people\": \"周杰伦\",\n" +
                "            \"music\": \"周大侠\",\n" +
                "            \"url\": 377573,\n" +
                "            \"rid\": 377573,\n" +
                "            \"song_time\": \"00\",\n" +
                "            \"album\": \"2007世界巡回演唱会\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject object = JSONObject.parseObject(str);
        List<Object> musicList = createJavaBeanByJson("Music", object);
        musicList.forEach(System.out::println);
    }
    /**
     * 将JSON转换为对应字段名的JavaBean
     * @param jsonObject 输入一个JsonObject对象
     * @return 返回一个JavaBean对象
     * 通过反射代理的方式生成JavaBean
     */
    public static List<Object> createJavaBeanByJson(String beanName, JSONObject jsonObject){
        List<Object> objectList = new ArrayList<>();
        /**
         * First get the capacity of
         * the json object and determine the number
         * of traverses needed later
         */
        int size = jsonObject.size();
        jsonObject.forEach(new BiConsumer<String, Object>() {
            /**
             * Performs this operation on the given arguments.
             * @param s the first input argument
             * @param o the second input argument
             */
            @Override
            public void accept(String s, Object o) {
                Class<?>[] dataList = o.getClass().getDeclaredClasses();
                // 根据每一个class对象获得dataList中每一个歌曲的实体对象
                Field[] declaredFields = dataList.getClass().getDeclaredFields();
                Object classByBeanName = getClassByBeanName(beanName, declaredFields);
                objectList.add(classByBeanName);
            }

            /**
             * Returns a composed {@code BiConsumer} that performs, in sequence, this
             * operation followed by the {@code after} operation. If performing either
             * operation throws an exception, it is relayed to the caller of the
             * composed operation.  If performing this operation throws an exception,
             * the {@code after} operation will not be performed.
             *
             * @param after the operation to perform after this operation
             * @return a composed {@code BiConsumer} that performs in sequence this
             * operation followed by the {@code after} operation
             * @throws NullPointerException if {@code after} is null
             */
            @NotNull
            @Override
            public BiConsumer<String, Object> andThen(@NotNull BiConsumer<? super String, ? super Object> after) {
                return BiConsumer.super.andThen(after);
            }
        });
        return objectList;
    }

    public static Object getClassByBeanName(String className,Object...args){
        Class[] classes = new Class[args.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = args[i].getClass();
        }
        Object obj = null;
        try {
            obj = Class.forName(className).getConstructor(classes).newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
