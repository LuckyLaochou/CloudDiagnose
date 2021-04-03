package cn.laochou.diagnose.service;

import cn.laochou.diagnose.bo.UserBO;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.search.UserSearchCondition;

import java.util.List;

public interface UserService {

    boolean insertUser(UserBO user);

    User selectUserByPhoneAndPassword(String phone, String password);

    User selectUserById(int id);

    List<User> selectAllUser();

    void updateUser(User user);

    void delUserById(int id);

    List<User> selectUserByCondition(UserSearchCondition condition);
}
