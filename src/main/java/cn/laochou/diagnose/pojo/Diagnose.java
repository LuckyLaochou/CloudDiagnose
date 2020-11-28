package cn.laochou.diagnose.pojo;



/**
 * 诊断复诊
 */
public class Diagnose {

    private int id;

    private int requestId;

    private int userId;

    private String diagnoseResult;

    private String advices;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDiagnoseResult() {
        return diagnoseResult;
    }

    public void setDiagnoseResult(String diagnoseResult) {
        this.diagnoseResult = diagnoseResult;
    }

    public String getAdvices() {
        return advices;
    }

    public void setAdvices(String advices) {
        this.advices = advices;
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
