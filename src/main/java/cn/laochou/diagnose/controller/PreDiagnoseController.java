package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.pojo.PreDiagnose;
import cn.laochou.diagnose.pojo.PreDiagnoseData;
import cn.laochou.diagnose.pojo.Symptoms;
import cn.laochou.diagnose.prediagnose.PreDiagnoseUtil;
import cn.laochou.diagnose.service.PreDiagnoseService;
import cn.laochou.diagnose.service.RequestService;
import cn.laochou.diagnose.service.SymptomsService;
import cn.laochou.diagnose.util.DateUtils;
import cn.laochou.diagnose.vo.RequestDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 预诊断处理
 */
@Controller
@RequestMapping("/pre")
public class PreDiagnoseController {

    @Autowired
    private SymptomsService symptomsService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private PreDiagnoseService preDiagnoseService;

    @RequestMapping("/diagnose/{id}")
    @ResponseBody
    public void preDiagnose(@PathVariable("id") int requestId) {
        List<Symptoms> symptoms = symptomsService.getAllSymptoms();
        RequestDetailVO requestDetail = requestService.getRequestDetailById(requestId);
        List<PreDiagnoseData> datas = new ArrayList<>();
        for(Symptoms item : symptoms) {
            PreDiagnoseData data = new PreDiagnoseData();
            data.setSymptomsId(item.getId());
            data.setSymptomsName(item.getName());
            data.setSimilarity(PreDiagnoseUtil.getSimilarity(item.getSymptoms(), requestDetail.getContent()));
            datas.add(data);
            System.out.println(data);
        }
        // 排序
        datas.sort((o1, o2) -> o2.getSimilarity() - o1.getSimilarity());
        List<PreDiagnoseData> results = new ArrayList<>();
        int size = 0;
        for(PreDiagnoseData data : datas) {
            if(size < 5 && data.getSimilarity() > 0) {
                results.add(data);
                size++;
            }else {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < results.size(); i++) {
            if(i != results.size() - 1) {
                stringBuilder.append(results.get(i).getSymptomsName()).append("、");
            }else {
                stringBuilder.append(results.get(i).getSymptomsName());
            }
        }
        System.out.println(stringBuilder.toString());
        // 预处理结果，插入数据库
        String preDiagnoseString = stringBuilder.toString();
        PreDiagnose preDiagnose = new PreDiagnose();
        preDiagnose.setPreDiagnoseResult(preDiagnoseString);
        preDiagnose.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        preDiagnose.setUpdateTime(DateUtils.getTimeFormDefaultFormat());
        preDiagnose.setRequestId(requestId);
        preDiagnoseService.insertPreDiagnose(preDiagnose);
        // 修改请求处理状态
        requestService.updateRequestByPreDiagnose(requestId);
        // 预处理过程结束
    }


}
