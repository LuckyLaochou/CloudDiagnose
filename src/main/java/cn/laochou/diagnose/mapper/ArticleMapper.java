package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public int insertArticle(Article article);


    public Article getArticleById(int id);


    public List<Article> getAllArticle();

}
