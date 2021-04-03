package cn.laochou.diagnose.pojo;

import lombok.Data;

/**
 * 诊断请求
 */
public class Request {

    private int id;

    private int userId;

    private String department;

    private String content;

    private String pictures;

    private String video;

    private String isPreDiagnose;

    private String isDiagnose;

    private String isDispose;

    private String createTime;

    private String updateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getIsPreDiagnose() {
        return isPreDiagnose;
    }

    public void setIsPreDiagnose(String isPreDiagnose) {
        this.isPreDiagnose = isPreDiagnose;
    }

    public String getIsDiagnose() {
        return isDiagnose;
    }

    public void setIsDiagnose(String isDiagnose) {
        this.isDiagnose = isDiagnose;
    }

    public String getIsDispose() {
        return isDispose;
    }

    public void setIsDispose(String isDispose) {
        this.isDispose = isDispose;
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


    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", userId=" + userId +
                ", department='" + department + '\'' +
                ", content='" + content + '\'' +
                ", pictures='" + pictures + '\'' +
                ", video='" + video + '\'' +
                ", isPreDiagnose='" + isPreDiagnose + '\'' +
                ", isDiagnose='" + isDiagnose + '\'' +
                ", isDispose='" + isDispose + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
