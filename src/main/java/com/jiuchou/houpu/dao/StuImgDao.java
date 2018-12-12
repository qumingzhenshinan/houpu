package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.StuImg;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StuImgDao {
    List<StuImg> query(String pid);
}
