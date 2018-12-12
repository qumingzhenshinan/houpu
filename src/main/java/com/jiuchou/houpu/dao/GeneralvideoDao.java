package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Generalvideo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface GeneralvideoDao {

    List<Generalvideo> queryAll();

    Generalvideo queryById(String gid);

    List<Generalvideo> queryByKind(@Param("gsbuject") String gsbuject, @Param("gclass")String gclass, @Param("gclassify")String gclassify);
    List<Generalvideo> queryByGsbuject(@Param("gsbuject") String gsbuject);
    List<Generalvideo> queryByGclass( @Param("gclass")String gclass);
    List<Generalvideo> queryByGclassify(@Param("gclassify")String gclassify);
    List<Generalvideo> queryByGsbujectAndGclass(@Param("gsbuject") String gsbuject, @Param("gclass")String gclass);
    List<Generalvideo> queryByGclassAndGclassify(@Param("gclass")String gclass, @Param("gclassify")String gclassify);
    List<Generalvideo> queryByGsbujectAndGclassify(@Param("gsbuject") String gsbuject,@Param("gclassify")String gclassify);

    List<Generalvideo> queryByTeacherId(String teacherId);

    List<Generalvideo> queryByCreatTime(@Param("gsbuject") String gsbuject, @Param("gclass")String gclass,@Param("gclassify")String gclassify);

    List<Generalvideo> queryByMoney(@Param("gsbuject") String gsbuject, @Param("gclass")String gclass,@Param("gclassify")String gclassify);

    List<Generalvideo> queryByKillEndTime(Date date);

    List<Generalvideo> queryRecommend(@Param("uid") String uid,@Param("etid") String etid);

    List<Generalvideo> queryByValue(@Param("value") String value);

}
