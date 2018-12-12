package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.ArticleImgDao;
import com.jiuchou.houpu.entity.ArticleImg;
import com.jiuchou.houpu.service.ArticleImgService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "articleImgService")
@Transactional
public class ArticleImgServiceImpl implements ArticleImgService {
    @Resource
    ArticleImgDao articleImgDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<ArticleImg> select() {
        List<ArticleImg> list = articleImgDao.query();
        if (list!=null && list.size()>0){
            ArticleImgData articleImgData = new ArticleImgData();
            articleImgData.setArticleImg(list);
            return RestFulUtil.getInstance().getResuFulBean(articleImgData,200,"获取图片正常");
        }else{
            return RestFulUtil.getInstance().getResuFulBean(null,201,"未获取到图片");
        }
    }
}

class ArticleImgData{
    private List<ArticleImg> articleImg;

    public List<ArticleImg> getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(List<ArticleImg> articleImg) {
        this.articleImg = articleImg;
    }
}