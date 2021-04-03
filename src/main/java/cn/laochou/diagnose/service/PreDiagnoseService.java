package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.PreDiagnose;

/**
 * 预处理服务
 */
public interface PreDiagnoseService {

    void insertPreDiagnose(PreDiagnose preDiagnose);

    PreDiagnose getPreDiagnoseByRequestId(int id);
}
