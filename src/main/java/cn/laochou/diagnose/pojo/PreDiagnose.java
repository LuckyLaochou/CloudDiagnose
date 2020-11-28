package cn.laochou.diagnose.pojo;


import lombok.Data;


/**
 * 诊断预诊
 */
public class PreDiagnose {


    private int id;

    private int requestId;

    private String preDiagnoseResult;

    private String createTime;

    private String updateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getPreDiagnoseResult() {
        return preDiagnoseResult;
    }

    public void setPreDiagnoseResult(String preDiagnoseResult) {
        this.preDiagnoseResult = preDiagnoseResult;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
