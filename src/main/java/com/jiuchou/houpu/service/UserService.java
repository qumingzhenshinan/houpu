package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.User;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    RestFulBean<User> selectById(String id);

    boolean updateUserName(String userName,String uid);

    boolean updHeadImgUrl(MultipartFile newProfile, String uid);

    User login(String phoneNo,String passWord);

    int regist(String phoneNo,String passWord);

    int updatePassWord(String passWord1,String passWord2,String phoneNo);

}
