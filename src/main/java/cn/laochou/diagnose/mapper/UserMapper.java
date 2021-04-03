package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.bo.UserBO;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.search.UserSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(UserBO user);

    User selectUserByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);


    User selectUserById(int id);

    List<User> selectAllUser();

    void updateUser(User user);

    void delUserById(int id);

    List<User> selectUserByCondition(UserSearchCondition condition);
}
