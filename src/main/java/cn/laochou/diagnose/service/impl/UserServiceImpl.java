package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.UserMapper;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertUser(User user) {
        int row = userMapper.insertUser(user);
        if(row > 0) return true;
        return false;
    }

    @Override
    public User selectUserByPhoneAndPassword(String phone, String password) {
        return userMapper.selectUserByPhoneAndPassword(phone, password);
    }
}
