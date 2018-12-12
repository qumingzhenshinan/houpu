package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.VideoPdf;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoPdfDao {
//通过课程id关联查询对应的讲义
   VideoPdf queryPdfById(String gid);
}
