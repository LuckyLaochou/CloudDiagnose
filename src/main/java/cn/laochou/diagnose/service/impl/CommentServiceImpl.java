package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.CommentMapper;
import cn.laochou.diagnose.pojo.Comment;
import cn.laochou.diagnose.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public List<Comment> getCommentsByArticleId(int articleId) {
        return commentMapper.getCommentsByArticleId(articleId);
    }

    @Override
    public boolean addComment(Comment comment) {
        int res = commentMapper.insertComment(comment);
        return res > 0;
    }

}
