package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.VideoChild;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface VideoChildDao {
    //通过课程id查询对应的章节列表
    List<VideoChild> queryChildById(String gid);
}
