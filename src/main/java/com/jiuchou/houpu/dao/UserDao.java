package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserDao {

   User queryById(String id);

   void updateUserName(@Param("userName") String userName, @Param("uid") String uid);

   void updateUserProfilePath(User user);

   User queryByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);

   User queryByPhoneNoAndPassword(@Param("phoneNo") String phoneNo,@Param("password") String password);

   boolean add(@Param("uid") String uid,@Param("passWord") String passWord,@Param("phoneNo") String phoneNo);

   void updatePassWord(@Param("passWord") String passWord,@Param("phoneNo") String phoneNo);

   User queryByPhoneNo(String phoneNo);

}
