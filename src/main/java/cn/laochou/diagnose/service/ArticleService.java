package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Article;

import java.util.List;

public interface ArticleService {

    public boolean publishArticle(Article article);


    public Article getArticleById(int id);


    public List<Article> getAllArticle();


    List<Article> searchArticleByKeyword(String keyword);
}
