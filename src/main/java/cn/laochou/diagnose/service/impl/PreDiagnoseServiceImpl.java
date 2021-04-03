package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.PreDiagnoseMapper;
import cn.laochou.diagnose.pojo.PreDiagnose;
import cn.laochou.diagnose.service.PreDiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreDiagnoseServiceImpl implements PreDiagnoseService {

    @Autowired
    private PreDiagnoseMapper preDiagnoseMapper;

    @Override
    public void insertPreDiagnose(PreDiagnose preDiagnose) {
        preDiagnoseMapper.insertPreDiagnose(preDiagnose);
    }

    @Override
    public PreDiagnose getPreDiagnoseByRequestId(int id) {
        return preDiagnoseMapper.getPreDiagnoseByRequestId(id);
    }
}
