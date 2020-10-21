package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.User;

public interface UserService {

    boolean insertUser(User user);

    User selectUserByPhoneAndPassword(String phone, String password);

}
