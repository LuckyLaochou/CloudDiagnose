package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUser(User user);

}
