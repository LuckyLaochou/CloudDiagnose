package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Symptoms;
import cn.laochou.diagnose.search.SymptomsSearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SymptomsMapper {


    List<Symptoms> getAllSymptoms();

    void updateSymptoms(Symptoms symptoms);

    void delSymptomsById(int id);

    List<Symptoms> searchSymptomsByCondition(SymptomsSearchCondition condition);

    void insertSymptoms(Symptoms symptoms);
}
