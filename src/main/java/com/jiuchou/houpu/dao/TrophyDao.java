package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Trophy;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrophyDao {
    List<Trophy> query();
    Trophy queryById(String pid);
}
