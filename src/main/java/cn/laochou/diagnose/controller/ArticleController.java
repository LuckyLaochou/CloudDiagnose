package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.common.ReturnBody;
import cn.laochou.diagnose.pojo.Article;
import cn.laochou.diagnose.pojo.Comment;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.ArticleService;
import cn.laochou.diagnose.service.CommentService;
import cn.laochou.diagnose.service.UserService;
import cn.laochou.diagnose.util.DateUtils;
import cn.laochou.diagnose.util.FileUtils;
import cn.laochou.diagnose.vo.CommentVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责Article的一系列请求
 */
@RequestMapping("/article")
@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/publish")
    @ResponseBody
    public ReturnBody<Object> publishArticle(HttpServletRequest request, Article article) {
        log.info(JSON.toJSONString(article));
        // 在这里需要判断用户的身份和用户是否登录
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            // 没有登陆
            // todo 应该跳转到登录页面
            article.setUserId(1);
        }else {
            article.setUserId(user.getId());
        }
        article.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        article.setUpdateTime(DateUtils.getTimeFormDefaultFormat());
        boolean res = articleService.publishArticle(article);
        if(res) {
            return ReturnBody.getSuccessReturnBody("发表成功");
        }
        return ReturnBody.getSuccessReturnBody("发表失败");
    }


    @RequestMapping("/uploadImage")
    @ResponseBody
    public JSONObject uploadImage(@RequestParam("editormd-image-file") MultipartFile file, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        if(file != null) {
            String imagePath = FileUtils.uploadFile(file);
            log.info(imagePath);
            jsonObject.put("url", imagePath);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success!");
            log.info(JSON.toJSONString(jsonObject));
            return jsonObject;
        }
        jsonObject.put("success", 0);
        jsonObject.put("message", "upload error!");
        return jsonObject;
    }


    @RequestMapping("/get/{id}")
    public ModelAndView getArticleById(@PathVariable(name = "id")int id) {
        ModelAndView modelAndView = new ModelAndView();
        Article article = articleService.getArticleById(id);
        log.info(JSON.toJSONString(article));
        if(article == null) {
            modelAndView.setViewName("blog");
            return modelAndView;
        }
        List<Comment> comments = commentService.getCommentsByArticleId(id);
        List<CommentVO> commentVOS = new ArrayList<>();
        for(Comment comment : comments) {
            CommentVO commentVO = new CommentVO();
            int userId = comment.getUserId();
            User user = userService.selectUserById(userId);
            BeanUtils.copyProperties(comment, commentVO);
            commentVO.setUserName(user.getName());
            log.info(JSON.toJSONString(commentVO));
            commentVOS.add(commentVO);
        }
        modelAndView.setViewName("singleblog");
        modelAndView.addObject("comments", commentVOS);
        modelAndView.addObject("article", article);
        return modelAndView;
    }




}
