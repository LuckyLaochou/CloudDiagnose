package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Auth;
import cn.laochou.diagnose.search.AuthSearchCondition;
import cn.laochou.diagnose.vo.AuthVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {


    List<AuthVO> selectAllAuth();

    void addAuth(Auth auth);

    void updateAuthByResult(Auth auth);

    List<AuthVO> selectAllAuthByCondition(AuthSearchCondition condition);
}
