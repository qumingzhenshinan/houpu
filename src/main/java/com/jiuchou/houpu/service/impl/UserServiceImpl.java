package com.jiuchou.houpu.service.impl;


import com.jiuchou.houpu.dao.UserDao;
import com.jiuchou.houpu.entity.User;
import com.jiuchou.houpu.service.UserService;
import com.jiuchou.houpu.util.MD5;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    public UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<User> selectById(String id) {
        User user = userDao.queryById(id);
        if (user != null) {
            return RestFulUtil.getInstance().getResuFulBean(user, 200, "数据查询正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "数据查询失败");
        }
    }

    @Override
    public void updateUserName(String userName,String uid) {
        userDao.updateUserName(userName,uid);
    }

    @Override
    public  RestFulBean<User> updHeadImgUrl(MultipartFile newProfile,String uid) {
        // 根据Windows和Linux配置不同的头像保存路径
        String profilesPath = "C:/static/userHeadImg/";
        if (!newProfile.isEmpty()) {
            // 当前用户
            User user = userDao.queryById(uid);
            String profilePathAndNameDB = userDao.queryById(user.getUid()).getHeadImgUrl();
            // 默认以原来的头像名称为新头像的名称，这样可以直接替换掉文件夹中对应的旧头像
            String newProfileName = profilePathAndNameDB;
            // 若头像名称不存在
            if (profilePathAndNameDB == null || "".equals(profilePathAndNameDB)) {
                newProfileName = profilesPath+ System.currentTimeMillis()+ newProfile.getOriginalFilename();
                // 路径存库
                user.setHeadImgUrl(newProfileName);
                userDao.updateUserProfilePath(user);
            }
            // 磁盘保存
            BufferedOutputStream out = null;
            try {
                File folder = new File(profilesPath);
                if (!folder.exists())
                    folder.mkdirs();
                out = new BufferedOutputStream(new FileOutputStream(newProfileName));
                // 写入新文件
                out.write(newProfile.getBytes());
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
                return RestFulUtil.getInstance().getResuFulBean(null, 201,"设置头像失败");
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return RestFulUtil.getInstance().getResuFulBean(null, 200,"设置头像成功");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201,"设置头像失败");
        }
    }


    @Override
    public User login(String phoneNo, String passWord) {
        User user = userDao.queryByPhoneNoAndPassword(phoneNo, passWord);
        if (user!=null){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public int regist(String phoneNo,String passWord) {
        String s = UUID.randomUUID().toString();
        MD5 md5 = new MD5(passWord);
        String passWord1 = md5.compute();
        if (phoneNo!=null&&!phoneNo.equals("")){
            User user = userDao.queryByPhoneNo(phoneNo);
            if (user==null) {
                boolean b = userDao.add(s,passWord1,phoneNo);
                if (b){
                    return 1; //注册成功
                }else {
                    return 2;  //注册失败
                }
            }else {
                return 3;   //手机号已存在
            }
        }
            return 4;   //手机号输入有误
    }

    @Override
    public int updatePassWord(String passWord1, String passWord2, String phoneNo) {
        if (passWord1.equals(passWord2)) {
            MD5 md5 = new MD5(passWord1);
            String passWord = md5.compute();
            userDao.updatePassWord(passWord, phoneNo);
            return 1;
        }else {
            return 0;
        }

    }
}


class UserData {
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}

@Configuration
class CommonConfiguration {
    /**
     * 文件上传配置，在application配置文件中设置不起作用！
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize("10240KB"); // KB,MB
        // 设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
}