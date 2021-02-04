package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.RequestService;
import cn.laochou.diagnose.service.UserService;
import cn.laochou.diagnose.vo.RequestDetailVO;
import cn.laochou.diagnose.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 有关申请的一些请求
 */
@Controller
@RequestMapping("/request")
public class RequestController {


    @Autowired
    private RequestService requestService;


    @Autowired
    private UserService userService;

    /**
     * 诊断大厅
     * @return
     */
    @RequestMapping("/hall")
    public ModelAndView hall(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User doctor = (User) request.getSession().getAttribute("user");
        // todo 删除测试逻辑
        if(doctor == null) {
            doctor = new User();
        }
        doctor.setDepartment("皮肤科");
        String department = doctor.getDepartment();
        // 根据department来查找request
        List<RequestVO> requests = requestService.getRequestByDepartment(department);
        modelAndView.addObject("requests", requests);
        modelAndView.addObject("doctor", doctor);
        modelAndView.setViewName("hall");
        return modelAndView;
    }


    @RequestMapping("/get/{id}")
    public ModelAndView getRequestById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detail");
        RequestDetailVO detail = requestService.getRequestDetailById(id);
        modelAndView.addObject("detail", detail);
        return modelAndView;
    }

}
