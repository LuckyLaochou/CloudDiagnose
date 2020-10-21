package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int insertUser(User user);

    User selectUserByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

}
