package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.PreDiagnose;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PreDiagnoseMapper {

    void insertPreDiagnose(PreDiagnose preDiagnose);

    PreDiagnose getPreDiagnoseByRequestId(int id);
}
