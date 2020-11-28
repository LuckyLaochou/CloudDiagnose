package cn.laochou.diagnose.service.impl;

import cn.laochou.diagnose.mapper.ArticleMapper;
import cn.laochou.diagnose.pojo.Article;
import cn.laochou.diagnose.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean publishArticle(Article article) {
        int res = articleMapper.insertArticle(article);
        // 返回结果大于0，表示插入成功，影响记录1行。
        if(res > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Article getArticleById(int id) {
        Article article = articleMapper.getArticleById(id);
        if(article == null) {
            return null;
        }
        return article;
    }
}
