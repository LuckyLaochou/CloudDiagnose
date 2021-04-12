package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.AuthMapper;
import cn.laochou.diagnose.pojo.Auth;
import cn.laochou.diagnose.search.AuthSearchCondition;
import cn.laochou.diagnose.service.AuthService;
import cn.laochou.diagnose.vo.AuthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<AuthVO> selectAllAuth() {
        return authMapper.selectAllAuth();
    }

    @Override
    public void addAuth(Auth auth) {
        authMapper.addAuth(auth);
    }

    @Override
    public void updateAuthByResult(Auth auth) {
        authMapper.updateAuthByResult(auth);
    }

    @Override
    public List<AuthVO> selectAllAuthByCondition(AuthSearchCondition condition) {
        return authMapper.selectAllAuthByCondition(condition);
    }
}
