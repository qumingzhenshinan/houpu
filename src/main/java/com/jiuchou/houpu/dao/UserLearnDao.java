package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.UserLearn;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserLearnDao {
    boolean add(UserLearn userLearn);

    List<UserLearn> queryAll(String uid);
}
