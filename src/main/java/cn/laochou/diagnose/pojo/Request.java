package cn.laochou.diagnose.pojo;

import lombok.Data;

/**
 * 诊断请求
 */
@Data
public class Request {

    private int id;

    private int userId;

    private String department;

    private String content;

    private String pritures;

    private String video;

    private int isPreDiagnose;

    private int isDiagnose;

    private int isDispose;

    private String createTime;

    private String updateTime;

}
