package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public List<Comment> getCommentsByArticleId(int articleId);

    int insertComment(Comment comment);
}
