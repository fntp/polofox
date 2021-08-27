package com.polofox.application.stock.eastmoney.doReq;

import com.polofox.application.stock.eastmoney.bean.AllHkStockDf;
import com.polofox.application.stock.eastmoney.service.ListService;
import com.polofox.application.stock.eastmoney.service.impl.ListServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Write By SunChengXin
 * @title: DoHkReq
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-18:26
 */
public class DoHkReq {
    private static ListService service = new ListServiceImpl();
    public static void main(String[] args) {
        List<AllHkStockDf> hkStockDfList = service.getHkStockDfList("http://10.push2.eastmoney.com/api/qt/clist/get?pn=1&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:128+t:3,m:128+t:4,m:128+t:1,m:128+t:2&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152&_=1630046678278");
        hkStockDfList.forEach(System.out::println);
    }
}
