package com.polofox.application.stock.eastmoney.doReq;
import com.polofox.application.stock.eastmoney.bean.AllHkStockDf;
import com.polofox.application.stock.eastmoney.bean.HkStock;
import com.polofox.application.stock.eastmoney.service.ListService;
import com.polofox.application.stock.eastmoney.service.impl.ListServiceImpl;
import com.polofox.application.stock.eastmoney.utils.GeReqUrlInfo;
import com.polofox.log.Log;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Write By SunChengXin
 * @title: DoHkReq
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/27-18:26
 */
public class DoHkReq {
    private static final ListService service = new ListServiceImpl();
    public static List<HkStock> getHkStockList(){
        Log.log();
        List<AllHkStockDf> hkStockDfList = service.getHkStockDfList(GeReqUrlInfo.getHkBaseUrl());
        hkStockDfList.forEach(System.out::println);
        Log.log("正在进行本地API封装...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<HkStock> list = new ArrayList<>();
        hkStockDfList.forEach(allHkStockDf ->{
            try {
                Thread.sleep(1000);
                HkStock hkStock = new HkStock();
                hkStock.setStockCode(allHkStockDf.getF12());
                hkStock.setStockName(allHkStockDf.getF14());
                hkStock.setHKD(String.valueOf(allHkStockDf.getF2()));
                hkStock.setChgE(String.valueOf(allHkStockDf.getF4()));
                hkStock.setChgF(String.valueOf(allHkStockDf.getF3()));
                hkStock.setOpen(String.valueOf(allHkStockDf.getF17()));
                hkStock.setHigh(String.valueOf(allHkStockDf.getF15()));
                hkStock.setLow(String.valueOf(allHkStockDf.getF16()));
                hkStock.setClose(String.valueOf(allHkStockDf.getF18()));
                hkStock.setVol(String.valueOf(allHkStockDf.getF5()));
                hkStock.setTO(String.valueOf(allHkStockDf.getF6()));
                list.add(hkStock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return list;
    }
}
