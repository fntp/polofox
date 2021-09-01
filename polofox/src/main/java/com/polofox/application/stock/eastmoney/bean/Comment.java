package com.polofox.application.stock.eastmoney.bean;
import com.polofox.log.Info;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Write By SunChengXin
 * @title: Comment
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-13:38
 */
@Data
@Setter
@Getter
@ToString
public class Comment {
    @Info(info = "用户Id")
    private String userId;
    @Info(info = "评论标题")
    private String postTitle;
    @Info(info = "用户昵称")
    private String userNickName;
    @Info(info = "阅读量")
    private String postClickCount;
    @Info(info = "评论数")
    private String postCommentCount;
    @Info(info = "股吧代码")
    private String stockbarCode;
    @Info(info = "股吧名称")
    private String stockbarName;
    @Info(info = "股吧类型代码")
    private String stockbarType;
}
