package cn.laochou.diagnose.controller;

import cn.laochou.diagnose.pojo.Comment;
import cn.laochou.diagnose.pojo.User;
import cn.laochou.diagnose.service.CommentService;
import cn.laochou.diagnose.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    public String addComment(HttpServletRequest request, String content, int articleId) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setUserId(userId);
        comment.setContent(content);
        comment.setCreateTime(DateUtils.getTimeFormDefaultFormat());
        comment.setUpdateTime(DateUtils.getTimeFormDefaultFormat());
        commentService.addComment(comment);
        return String.format("redirect:/article/get/%d", articleId);
    }


}
