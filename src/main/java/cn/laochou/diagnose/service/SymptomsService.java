package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Symptoms;
import cn.laochou.diagnose.search.SymptomsSearchCondition;

import java.util.List;

public interface SymptomsService {

    List<Symptoms> getAllSymptoms();

    void updateSymptoms(Symptoms symptoms);

    void delSymptomsById(int id);

    List<Symptoms> searchSymptomsByCondition(SymptomsSearchCondition condition);

    void insertSymptoms(Symptoms symptoms);
}
