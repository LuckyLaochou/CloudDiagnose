package cn.laochou.diagnose.pojo;

import lombok.Data;

/**
 * 症状
 */
public class Symptoms {

    private int id;

    private String name;

    private String symptoms;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
