package cn.laochou.diagnose.pojo;


import lombok.Data;


/**
 * 诊断预诊
 */
@Data
public class PreDiagnose {


    private int id;

    private int requestId;

    private String preDiagnoseResult;

    private String createTime;

    private String updateTime;

}
