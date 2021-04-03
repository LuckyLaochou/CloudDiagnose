package cn.laochou.diagnose.search;

/**
 * 症状查询条件
 */
public class SymptomsSearchCondition {

    private Integer id;

    private String name;

    private String symptoms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
