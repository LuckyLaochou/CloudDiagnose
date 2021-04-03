package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.DiagnoseMapper;
import cn.laochou.diagnose.pojo.Diagnose;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.DiagnoseService;
import cn.laochou.diagnose.vo.DiagnoseDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnoseServiceImpl implements DiagnoseService {


    @Autowired
    private DiagnoseMapper diagnoseMapper;

    @Override
    public List<DiagnoseDetailVO> getAlreadyDiagnoseByUserId(User user) {
        return diagnoseMapper.getAlreadyDiagnoseByUserId(user);
    }

    @Override
    public Boolean insertDiagnose(Diagnose diagnose) {
        int result = diagnoseMapper.insertDiagnose(diagnose);
        return result > 0;
    }

    @Override
    public Diagnose getDiagnoseByRequestId(int id) {
        return diagnoseMapper.getDiagnoseByRequestId(id);
    }

}
