package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.common.ReturnBody;
import cn.laochou.diagnose.pojo.Comment;
import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.pojo.Symptoms;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.search.CommentSearchCondition;
import cn.laochou.diagnose.search.RequestSearchCondition;
import cn.laochou.diagnose.search.SymptomsSearchCondition;
import cn.laochou.diagnose.search.UserSearchCondition;
import cn.laochou.diagnose.service.CommentService;
import cn.laochou.diagnose.service.RequestService;
import cn.laochou.diagnose.service.SymptomsService;
import cn.laochou.diagnose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private SymptomsService symptomsService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/index")
    public String toIndex() {
       return "admin/index";
    }

    @RequestMapping("/console")
    public String console() {
        return "admin/home/console";
    }

    @RequestMapping("/user/toList")
    public String toList() {
        return "admin/user/user/list";
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public ReturnBody<List<User>> list() {
        List<User> users = userService.selectAllUser();
        return ReturnBody.getSuccessReturnBody("查询成功", users);
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public ReturnBody<Object> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ReturnBody.getSuccessReturnBody("修改成功");
    }

    @RequestMapping("/user/del/{id}")
    @ResponseBody
    public ReturnBody<Object> delUser(@PathVariable("id") int id) {
        userService.delUserById(id);
        return ReturnBody.getSuccessReturnBody("删除成功");
    }

    @RequestMapping("/user/search")
    @ResponseBody
    public ReturnBody<List<User>> searchUser(@RequestBody UserSearchCondition condition) {
        List<User> users = userService.selectUserByCondition(condition);
        return ReturnBody.getSuccessReturnBody("查找成功", users);
    }

    @RequestMapping("/request/list")
    @ResponseBody
    public ReturnBody<List<Request>> requestList() {
        List<Request> requests = requestService.selectAllRequest();
        return ReturnBody.getSuccessReturnBody("获取请求列表成功", requests);
    }

    @RequestMapping("/request/update")
    @ResponseBody
    public ReturnBody<Object> updateRequest(@RequestBody Request request) {
        requestService.updateRequest(request);
        return ReturnBody.getSuccessReturnBody("修改成功");
    }

    @RequestMapping("/request/del/{id}")
    @ResponseBody
    public ReturnBody<Object> delRequest(@PathVariable("id") int id) {
        requestService.delRequestById(id);
        return ReturnBody.getSuccessReturnBody("删除成功");
    }

    @RequestMapping("/request/search")
    @ResponseBody
    public ReturnBody<List<Request>> searchRequest(@RequestBody RequestSearchCondition condition) {
        List<Request> requests = requestService.searchRequestByCondition(condition);
        return ReturnBody.getSuccessReturnBody("查询申请成功", requests);
    }

    @RequestMapping("/request/toList")
    public String toRequestList() {
        return "admin/user/request/list";
    }

    @RequestMapping("/symptoms/toList")
    public String toUserRole() {
        return "/admin/user/symptoms/list";
    }

    @RequestMapping("/symptoms/list")
    @ResponseBody
    public ReturnBody<List<Symptoms>> symptomsList() {
        List<Symptoms> symptoms = symptomsService.getAllSymptoms();
        return ReturnBody.getSuccessReturnBody("获取所有症状成功", symptoms);
    }

    @RequestMapping("/symptoms/update")
    @ResponseBody
    public ReturnBody<Object> updateSymptoms(@RequestBody Symptoms symptoms) {
        symptomsService.updateSymptoms(symptoms);
        return ReturnBody.getSuccessReturnBody("修改成功");
    }

    @RequestMapping("/symptoms/del/{id}")
    @ResponseBody
    public ReturnBody<Object> delSymptoms(@PathVariable("id") int id) {
        symptomsService.delSymptomsById(id);
        return ReturnBody.getSuccessReturnBody("删除成功");
    }

    @RequestMapping("/symptoms/search")
    @ResponseBody
    public ReturnBody<List<Symptoms>> searchSymptoms(@RequestBody SymptomsSearchCondition condition) {
        List<Symptoms> symptoms = symptomsService.searchSymptomsByCondition(condition);
        return ReturnBody.getSuccessReturnBody("查询成功", symptoms);
    }

    @RequestMapping("/symptoms/add")
    @ResponseBody
    public ReturnBody<Object> addSymptoms(@RequestBody Symptoms symptoms) {
        symptomsService.insertSymptoms(symptoms);
        return ReturnBody.getSuccessReturnBody("添加成功");
    }

    @RequestMapping("/symptoms/form")
    public String toUserForm() {
        return "admin/user/symptoms/symptomsform";
    }


    @RequestMapping("/comment/toList")
    public String toCommentList() {
        return "admin/user/comment/list";
    }

    @RequestMapping("/comment/list")
    @ResponseBody
    public ReturnBody<List<Comment>> commentList() {
        List<Comment> comments = commentService.getAllComment();
        return ReturnBody.getSuccessReturnBody("查询成功", comments);
    }

    @RequestMapping("/comment/update")
    @ResponseBody
    public ReturnBody<Object> updateComment(@RequestBody Comment comment) {
        commentService.updateComment(comment);
        return ReturnBody.getSuccessReturnBody("修改成功");
    }

    @RequestMapping("/comment/del/{id}")
    @ResponseBody
    public ReturnBody<Object> delComment(@PathVariable("id") int id) {
        commentService.delCommentById(id);
        return ReturnBody.getSuccessReturnBody("删除成功");
    }

    @RequestMapping("/comment/search")
    @ResponseBody
    public ReturnBody<List<Comment>> searchCommentByCondition(@RequestBody CommentSearchCondition condition) {
        List<Comment> comments = commentService.searchCommentByCondition(condition);
        return ReturnBody.getSuccessReturnBody("查询成功", comments);
    }

    @RequestMapping("/auth/toList")
    public String toAuthList() {
        return "admin/user/auth/list";
    }

}
