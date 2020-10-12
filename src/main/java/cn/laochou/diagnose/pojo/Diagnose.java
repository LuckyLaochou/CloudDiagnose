package cn.laochou.diagnose.pojo;


import lombok.Data;


/**
 * 诊断复诊
 */
@Data
public class Diagnose {

    private int id;

    private int requestId;

    private int userId;

    private String diagnoseResult;

    private String advices;

    private String createTime;

    private String updateTime;

}
