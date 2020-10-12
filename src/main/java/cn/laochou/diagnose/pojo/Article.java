package cn.laochou.diagnose.pojo;


import lombok.Data;

/**
 * 文章
 */
@Data
public class Article {

    private int id;

    private String title;

    private String content;

    private int userId;

    private String keys;

    private int browserTimes;

    private int likee;

    private int isDeleted;

    private String createTime;

    private String updateTime;


}
