package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Article;

public interface ArticleService {

    public boolean publishArticle(Article article);


    public Article getArticleById(int id);


}
