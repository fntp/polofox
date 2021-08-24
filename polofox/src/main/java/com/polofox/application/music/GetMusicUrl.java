package com.polofox.application.music;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.polofox.application.music.bean.Music;
import com.polofox.application.music.util.HttpReq;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class GetMusicUrl {

    private static ArrayList<Music> musicList;

    private GetMusicUrl(){
        musicList = new ArrayList<>();
    }

    /**
     * 返回请求后获得的网页，此时网页整体结构已经被JS进行了修改
     * @param reqUrl  请求url地址
     * @return 返回一个json
     */
    public static String getReqJsonStr(String reqUrl,String searchSeed) throws Exception{
        WebClient readyWebClient = HttpReq.getReadyWebClient ();
         //获得首页页面
        HtmlPage htmlPage = readyWebClient.getPage(reqUrl);
        //截取搜索框
        HtmlTextInput input = (HtmlTextInput)htmlPage.getElementById("query");
        HtmlTextInput myInput =(HtmlTextInput) htmlPage.getElementById("myInput");
        //填充内容
        input.setValueAttribute(searchSeed);
        myInput.setValueAttribute(searchSeed);
        //开始截取搜索框
        HtmlElement button = null;
        DomNodeList<DomElement> buttons = htmlPage.getElementsByTagName("button");
        for (DomElement domElement : buttons) {
            // 根据目标元素 class 属性循环匹配
            if (domElement.getAttribute("class").equals("btn btn-primary search")) {
                button = (HtmlElement) domElement;
            }
        }
        //拿到等待js加载之后的网页
        assert button != null;
        HtmlPage page = button.click();
        return page.asXml();
    }

    public static ArrayList<Music> getMusicList(String reqUrl,String searchSeed) throws Exception {
        //拿到返回的响应体
        String response = getReqJsonStr(reqUrl, searchSeed);
        //使用Jsoup解析响应体
        Document document = HttpReq.parseResponse (response);
        //document = httpReq.getDocumentByBro(reqUrl);
        //获得document之后，开始拿歌曲
        Element result = document.getElementById("result");
        //拿到一百首歌
        assert result != null;
        Element list = result.select("[class=list-group]").get(0);
        Elements lis = list.select("[class=list-group-item]");
        int size = lis.select("[class=list-group-item]").size();
        System.out.println("size是"+size);
        for (int i = 0; i < size; i++) {
            String downLoadUrl = lis.get(i).child(2).attr("href");
            String singer =lis.get(i).child(3).text();
            String musicName = lis.get(i).child(4).text();
            Music music = new Music();
            music.setUrl(downLoadUrl);
            music.setArtist(singer);
            music.setTitle(musicName);
            musicList.add(music);
        }
        return musicList;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Music> list = getMusicList("https://myfreemp3music.com/", "周杰伦");
        System.out.println("获得的list空间为："+list.size());
        for (Music music : list) {
            System.out.println ("polofox爬虫已经嗅探到适配的MP3：歌手是：" + music.getArtist () + "--歌曲名称是：" + music.getTitle () + "--歌曲下载地址是：" + music.getUrl ());
        }
    }
}
