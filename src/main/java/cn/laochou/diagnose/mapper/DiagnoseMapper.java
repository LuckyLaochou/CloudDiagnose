package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Diagnose;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.vo.DiagnoseDetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiagnoseMapper {

    List<DiagnoseDetailVO> getAlreadyDiagnoseByUserId(User user);

    int insertDiagnose(Diagnose diagnose);
}
