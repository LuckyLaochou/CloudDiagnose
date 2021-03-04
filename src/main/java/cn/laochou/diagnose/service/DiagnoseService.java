package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Diagnose;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.vo.DiagnoseDetailVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiagnoseService {

    List<DiagnoseDetailVO> getAlreadyDiagnoseByUserId(User user);

    Boolean insertDiagnose(Diagnose diagnose);

}
