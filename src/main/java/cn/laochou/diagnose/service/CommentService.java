package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Comment;
import cn.laochou.diagnose.search.CommentSearchCondition;

import java.util.List;

public interface CommentService {

    public List<Comment> getCommentsByArticleId(int articleId);

    public boolean addComment(Comment comment);

    List<Comment> getAllComment();

    void updateComment(Comment comment);

    void delCommentById(int id);

    List<Comment> searchCommentByCondition(CommentSearchCondition condition);
}
