package com.polofox.application.stock.eastmoney.bean;

import lombok.Data;

/**
 * @author Write By SunChengXin
 * @title: UserInfo
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-15:25
 */
@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String userNickName;
    private String rc;
    private String userAge;
    private String userAppealState;
    private String userAppealTime;
    private String userGender;
    private String userIslocked;
    private String userRegTime;
    private String userSelectFundCount;
    private String userPostCount;
    private String userSelectStockCount;
}
