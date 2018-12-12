package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.CommentDao;
import com.jiuchou.houpu.entity.Comment;
import com.jiuchou.houpu.service.CommentService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service(value = "commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    public CommentDao commentDao;


    @Override
    public RestFulBean<Comment> select(String gid) {
        List<Comment> list = commentDao.query(gid);
        if (list!=null&&list.size()>0){
            CommentData commentData = new CommentData();
            commentData.setComments(list);
            return RestFulUtil.getInstance().getResuFulBean(commentData,200,"数据查询正常");
        }else{
            return RestFulUtil.getInstance().getResuFulBean(null,201,"数据查询失败");
        }
    }

    @Override
    public boolean insert(Comment comment) {
        String s = UUID.randomUUID().toString();
        Comment c = new Comment();
        c.setCid(s);
        c.setCgid(comment.getCgid());
        c.setCoid(comment.getCoid());
        c.setCreatTime(comment.getCreatTime());
        c.setContent(comment.getContent());
        c.setScore(comment.getScore());
        c.setCuid(comment.getCuid());
        boolean b = commentDao.add(c);
        if (b){
            return true;
        }else {
            return false;
        }
    }
}


class CommentData{
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}