package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.bo.UserBO;
import cn.laochou.diagnose.mapper.UserMapper;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.search.UserSearchCondition;
import cn.laochou.diagnose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertUser(UserBO user) {
        int row = userMapper.insertUser(user);
        if(row > 0) return true;
        return false;
    }

    @Override
    public User selectUserByPhoneAndPassword(String phone, String password) {
        return userMapper.selectUserByPhoneAndPassword(phone, password);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void delUserById(int id) {
        userMapper.delUserById(id);
    }

    @Override
    public List<User> selectUserByCondition(UserSearchCondition condition) {
        return userMapper.selectUserByCondition(condition);
    }

}
