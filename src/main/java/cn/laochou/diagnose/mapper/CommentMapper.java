package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Comment;
import cn.laochou.diagnose.search.CommentSearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public List<Comment> getCommentsByArticleId(int articleId);

    int insertComment(Comment comment);

    List<Comment> selectAllComment();

    void updateComment(Comment comment);

    void delCommentById(int id);

    List<Comment> searchCommentByCondition(CommentSearchCondition condition);
}
