package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.common.ReturnBody;
import cn.laochou.diagnose.pojo.Auth;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.search.AuthSearchCondition;
import cn.laochou.diagnose.service.AuthService;
import cn.laochou.diagnose.service.UserService;
import cn.laochou.diagnose.util.FileUtils;
import cn.laochou.diagnose.vo.AuthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    @ResponseBody
    public ReturnBody<List<AuthVO>> list() {
        List<AuthVO> authVOS = authService.selectAllAuth();
        return ReturnBody.getSuccessReturnBody("查询成功", authVOS);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ReturnBody<Object> add(HttpServletRequest request, @RequestParam(value = "pictures") MultipartFile pictures,
                                  @RequestParam(value = "department") String department) {
        User user = (User) request.getSession().getAttribute("user");
        Auth auth = new Auth();
        String picturesPath = FileUtils.uploadFile(pictures);
        auth.setImg(picturesPath);
        auth.setUserId(user.getId());
        auth.setDepartment(department);
        authService.addAuth(auth);
        return ReturnBody.getSuccessReturnBody("提交认证成功");
    }

    @RequestMapping("/update")
    @ResponseBody
    public ReturnBody<Object> update(@RequestBody Auth auth) {
        authService.updateAuthByResult(auth);
        if(auth.getResult().equals("认证通过")) {
            User user = new User();
            user.setId(auth.getUserId());
            user.setDepartment(auth.getDepartment());
            userService.updateUserByDepartment(user);
        }
        if(auth.getResult().equals("认证不通过")) {
            User user = new User();
            user.setId(auth.getUserId());
            user.setDepartment("用户系");
            userService.updateUserByDepartment(user);
        }
        return ReturnBody.getSuccessReturnBody("修改成功");
    }


    @RequestMapping("/search")
    @ResponseBody
    public ReturnBody<List<AuthVO>> search(@RequestBody AuthSearchCondition condition){
        List<AuthVO> authVOS = authService.selectAllAuthByCondition(condition);
        return ReturnBody.getSuccessReturnBody("查询成功", authVOS);
    }

}
