package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.common.ReturnBody;
import cn.laochou.diagnose.pojo.Article;
import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.ArticleService;
import cn.laochou.diagnose.service.RequestService;
import cn.laochou.diagnose.service.UserService;
import cn.laochou.diagnose.util.CheckUtils;
import cn.laochou.diagnose.util.DateUtils;
import cn.laochou.diagnose.util.FdfsUtils;
import cn.laochou.diagnose.util.FileUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 这个Controller主要服务于用户
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private ArticleService articleService;



    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ReturnBody<Object> userRegister(@RequestBody User user) {
        // 对于User里面的参数进行校验
        if(!CheckUtils.validIdCard(user.getIdCard())) {
            return ReturnBody.getParamErrorReturnBody("参数错误");
        }
        user.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        user.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        boolean res = userService.insertUser(user);
        if(res) return ReturnBody.getSuccessReturnBody("注册成功");
        return ReturnBody.getErrorReturnBody("注册失败");
    }


    /**
     * 用户登录
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ReturnBody<Object> userLogin(HttpServletRequest request, @RequestBody User user) {
        if(request.getSession().getAttribute("user") != null) {
            return ReturnBody.getSuccessReturnBody("您已经登录过了");
        }
        log.info(JSON.toJSONString(user));
        String phone = user.getPhone();
        String password = user.getPassword();
        User u = userService.selectUserByPhoneAndPassword(phone, password);
        if(u == null) {
            return ReturnBody.getSuccessReturnBody("该用户并不存在或者密码错误");
        }
        request.getSession().setAttribute("user", u);
        return ReturnBody.getSuccessReturnBody("登陆成功");
    }


    /**
     * 用户诊断申请
     * @param pictures
     * @param videos
     * @param content
     * @param department
     * @return
     */
    @RequestMapping("/request")
    @ResponseBody
    public ReturnBody<Object> userRequest(HttpServletRequest request, @RequestParam(value = "pictures", required = false)MultipartFile pictures, @RequestParam(value = "videos", required = false) MultipartFile videos,
                                  @RequestParam("content") String content, @RequestParam("department") String department) {
        Request diagnoseRequest = new Request();
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            // todo 这里便于开发就不直接返回了
            diagnoseRequest.setUserId(1);
//            return ReturnBody.getSuccessReturnBody( "您还没有登录");
        }else {
            diagnoseRequest.setUserId(user.getId());
        }
        // 开始判断
        if(pictures == null) {
            diagnoseRequest.setPictures("");
        }else {
            String picturesPath = FileUtils.uploadFile(pictures);
            diagnoseRequest.setPictures(picturesPath);
        }
        if(videos == null) {
            diagnoseRequest.setVideo("");
        }else {
            String videosPath = FileUtils.uploadFile(videos);
            diagnoseRequest.setVideo(videosPath);
        }
        diagnoseRequest.setContent(content);
        diagnoseRequest.setDepartment(department);
        diagnoseRequest.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        diagnoseRequest.setUpdateTime(DateUtils.getTimeFormDefaultFormat());
        log.info(JSON.toJSONString(diagnoseRequest));
        boolean res = requestService.insertRequest(diagnoseRequest);
        if(res) return ReturnBody.getSuccessReturnBody("申请成功");
        return ReturnBody.getSuccessReturnBody("申请失败");
    }


}
