package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getCommentsByArticleId(int articleId);

    public boolean addComment(Comment comment);
}
