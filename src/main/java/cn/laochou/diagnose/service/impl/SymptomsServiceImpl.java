package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.SymptomsMapper;
import cn.laochou.diagnose.pojo.Symptoms;
import cn.laochou.diagnose.search.SymptomsSearchCondition;
import cn.laochou.diagnose.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsServiceImpl implements SymptomsService {

    @Autowired
    private SymptomsMapper symptomsMapper;

    @Override
    public List<Symptoms> getAllSymptoms() {
        return symptomsMapper.getAllSymptoms();
    }

    @Override
    public void updateSymptoms(Symptoms symptoms) {
        symptomsMapper.updateSymptoms(symptoms);
    }

    @Override
    public void delSymptomsById(int id) {
        symptomsMapper.delSymptomsById(id);
    }

    @Override
    public List<Symptoms> searchSymptomsByCondition(SymptomsSearchCondition condition) {
        return symptomsMapper.searchSymptomsByCondition(condition);
    }

    @Override
    public void insertSymptoms(Symptoms symptoms) {
        symptomsMapper.insertSymptoms(symptoms);
    }
}
