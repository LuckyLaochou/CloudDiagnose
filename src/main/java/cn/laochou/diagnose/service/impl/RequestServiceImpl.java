package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.RequestMapper;
import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.search.RequestSearchCondition;
import cn.laochou.diagnose.service.RequestService;
import cn.laochou.diagnose.vo.RequestDetailVO;
import cn.laochou.diagnose.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestMapper requestMapper;

    @Override
    public boolean insertRequest(Request request) {
        int res = requestMapper.insertRequest(request);
        return res > 0;
    }

    @Override
    public List<RequestVO> getRequestByDepartment(String department) {
        return requestMapper.getRequestByDepartment(department);
    }

    @Override
    public RequestDetailVO getRequestDetailById(int id) {
        return requestMapper.getRequestDetailById(id);
    }

    @Override
    public List<RequestDetailVO> getRequestDetailByUserId(int id) {
        return requestMapper.getRequestDetailByUserId(id);
    }

    @Override
    public Boolean updateRequestByDiagnose(int id) {
        return requestMapper.updateRequestByDiagnose(id);
    }

    @Override
    public void updateRequestByPreDiagnose(int id) {
        requestMapper.updateRequestByPreDiagnose(id);
    }

    @Override
    public List<Request> selectAllRequest() {
        return requestMapper.selectAllRequest();
    }

    @Override
    public void updateRequest(Request request) {
        requestMapper.updateRequest(request);
    }

    @Override
    public void delRequestById(int id) {
        requestMapper.delRequestById(id);
    }

    @Override
    public List<Request> searchRequestByCondition(RequestSearchCondition condition) {
        return requestMapper.selectRequestByCondition(condition);
    }
}
