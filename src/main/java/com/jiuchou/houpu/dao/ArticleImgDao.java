package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.ArticleImg;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ArticleImgDao {

    List<ArticleImg> query();


}
