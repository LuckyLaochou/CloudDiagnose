package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.RequestMapper;
import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestMapper requestMapper;

    @Override
    public boolean insertRequest(Request request) {
        int res = requestMapper.insertRequest(request);
        if(res > 0) {
            return true;
        }
        return false;
    }
}
