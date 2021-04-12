package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Auth;
import cn.laochou.diagnose.search.AuthSearchCondition;
import cn.laochou.diagnose.vo.AuthVO;

import java.util.List;

public interface AuthService {

    List<AuthVO> selectAllAuth();

    void addAuth(Auth auth);

    void updateAuthByResult(Auth auth);

    List<AuthVO> selectAllAuthByCondition(AuthSearchCondition condition);
}
