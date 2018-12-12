package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.VideoTest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoTestDao {
    VideoTest query(String vcids);

}
