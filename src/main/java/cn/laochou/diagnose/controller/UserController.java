package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.common.ReturnBody;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.UserService;
import cn.laochou.diagnose.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个Controller主要服务于用户
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public ReturnBody userRegister(@RequestBody User user) {
        // 对于User里面的参数进行校验
        
        user.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        user.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        boolean res = userService.insertUser(user);
        if(res) return ReturnBody.getSuccessReturnBody("插入成功");
        return ReturnBody.getErrorReturnBody("插入失败");
    }

}
