package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.bo.UserBO;
import cn.laochou.diagnose.common.ReturnBody;
import cn.laochou.diagnose.pojo.Diagnose;
import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.ArticleService;
import cn.laochou.diagnose.service.DiagnoseService;
import cn.laochou.diagnose.service.RequestService;
import cn.laochou.diagnose.service.UserService;
import cn.laochou.diagnose.util.CheckUtils;
import cn.laochou.diagnose.util.DateUtils;
import cn.laochou.diagnose.util.FileUtils;
import cn.laochou.diagnose.vo.DiagnoseDetailVO;
import cn.laochou.diagnose.vo.RequestDetailVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Autowired
    private DiagnoseService diagnoseService;



    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ReturnBody<Object> userRegister(@RequestBody UserBO user) {
        System.out.println(user);
        if(!user.getPassword().equals(user.getRePassword())) {
            return ReturnBody.getSuccessReturnBody("密码不一致");
        }
        // 对于User里面的参数进行校验
//        if(!CheckUtils.validIdCard(user.getIdCard())) {
//            return ReturnBody.getParamErrorReturnBody("参数错误");
//        }
        user.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        user.setUpdateTime(DateUtils.getTimeFormDefaultFormat());
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
     * @param pictures 图片
     * @param videos 视频
     * @param content 内容
     * @param department 科系
     * @return
     */
    @RequestMapping("/request")
    @ResponseBody
    public ReturnBody<Object> userRequest(HttpServletRequest request, @RequestParam(value = "pictures", required = false)MultipartFile pictures, @RequestParam(value = "videos", required = false) MultipartFile videos,
                                  @RequestParam("content") String content, @RequestParam("department") String department) {
        Request diagnoseRequest = new Request();
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            return ReturnBody.getSuccessReturnBody("您还没登陆", null);
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
        if(res) return ReturnBody.getSuccessReturnBody("申请成功", diagnoseRequest.getId());
        return ReturnBody.getSuccessReturnBody("申请失败");
    }


    /**
     * 个人主页
     * @param request 请求对象
     * @return 主页
     */
    @RequestMapping("/my")
    public ModelAndView toMy(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView result = new ModelAndView();
        User user = (User) request.getSession().getAttribute("user");
        result.addObject("user", user);
        // 根据用户类别，查找不同的信息
        // 如果是普通用户，渲染的是自己的申请信息
        // 如果是医生，渲染的是自己的处理信息
        if(user.getRole() == 1) {
            List<RequestDetailVO> requestDetailVOS = requestService.getRequestDetailByUserId(user.getId());
            result.addObject("data", requestDetailVOS);
        }else if(user.getRole() == 2) {
            List<DiagnoseDetailVO> diagnoseDetailVOS = diagnoseService.getAlreadyDiagnoseByUserId(user);
            result.addObject("data", diagnoseDetailVOS);
        }
        result.setViewName("my");
        return result;
    }


    /**
     * 诊断请求
     * @param request
     * @param diagnose
     * @return
     */
    @RequestMapping("/diagnose")
    @ResponseBody
    public ReturnBody<Object> diagnose(HttpServletRequest request, @RequestBody Diagnose diagnose) {
        User user = (User) request.getSession().getAttribute("user");
        diagnose.setUserId(user.getId());
        diagnose.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        diagnose.setUpdateTime(DateUtils.getTimeFormDefaultFormat());
        boolean result = diagnoseService.insertDiagnose(diagnose);
        // 在这里，还需要修改Request中的状态哦
        boolean update = requestService.updateRequestByDiagnose(diagnose.getRequestId());
        return result && update ? ReturnBody.getSuccessReturnBody("success") : ReturnBody.getSuccessReturnBody("error");
    }
}
