package cn.laochou.diagnose.pojo;

import lombok.Data;

/**
 * 文章评论
 */
@Data
public class Comment {

    private int id;

    private int articleId;

    private int userId;

    private String content;

    private int likee;

    private String createTime;

    private String updateTime;

}
