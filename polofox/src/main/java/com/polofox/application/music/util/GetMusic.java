//package com.polofox.application.music.util;
//
//import com.sinsy.fntp.Entity.Agent;
//import org.jsoup.Connection;
//import org.jsoup.nodes.Document;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * @author fntp
// *
// */
//public class GetMusic {
//	private Agent agent;
//	private Connection connection;
//	private Map<String,String> headerMap;
//	public Map<String,String> SetheaderMap(String host) {
//		headerMap = new HashMap<String,String>();
//		headerMap.put("Host",host);
//		headerMap.put("Connection","keep-alive");
//		headerMap.put("Cache-Control","max-age=0");
//		headerMap.put("Upgrade-Insecure-Requests","1");
//		headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.48 Safari/537.36");
//        headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//        headerMap.put("Sec-Fetch-Site", "none");
//        headerMap.put("Sec-Fetch-Mode", "navigate");
//        headerMap.put("Sec-Fetch-User","?1");
//        headerMap.put("Sec-Fetch-Dest", "document");
//        headerMap.put("Accept-Encoding", "gzip, deflate, br");
//        headerMap.put("Accept-Language","zh-CN,zh;q=0.9");
//        return headerMap;
//	}
//	public static String getHost(String url) {
//		String cache = "";
//		if(url.contains("www.")) {
//			String regex1 = "www.(.*?).com";
//			String host = "";
//			Pattern pattern1 = Pattern.compile(regex1);
//			Matcher m = pattern1.matcher(url);
//			while (m.find()) {
//	            int i = 1;
//	            host+=m.group(i);
//	            i++;
//	        }
//			cache= host+".com";
//		}else if(url.contains("https://")){
//			String regex1 = "https://(.*?).com";
//			String host = "";
//			Pattern pattern1 = Pattern.compile(regex1);
//			Matcher m = pattern1.matcher(url);
//			while (m.find()) {
//	            int i = 1;
//	            host+=m.group(i);
//	            i++;
//	        }
//			cache = host+".com";
//		}else if(url.contains("http://")) {
//			String regex1 = "http://(.*?).com";
//			String host = "";
//			Pattern pattern1 = Pattern.compile(regex1);
//			Matcher m = pattern1.matcher(url);
//			while (m.find()) {
//	            int i = 1;
//	            host+=m.group(i);
//	            i++;
//	        }
//			cache= host+".com";
//		}
//	return cache;
//	}
//	public GetMusic(String url,String host) throws Exception{
//		 Document document = GetConnection(url,host).get();
//		 System.out.println(document.html());
//	}
//	/**
//	 * 		String User_Agent,
//			String Accept,
//			String Accept_language,
//			String Accept_Ecoding,
//			String Cache_Control,
//			String Connection
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		new GetMusic("https://search.kuwo.cn/r.s?"
//				+ "pn=0&rn=10&all=%E6%88%91%E4%B8%"
//				+ "8D%E5%AF%B9&rformat=json"
//				+ "&encoding=utf8&ft=music&vipver=0","search.kuwo.cn");
//	}
//}
