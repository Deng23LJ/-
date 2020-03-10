package com.mapper;

import com.entity.PersonAffairs;
import com.entity.UploadFile;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User login(Map<String ,Object> map) throws Exception;

    void regist(User user) throws Exception;

    User usernameCheck(String username) throws Exception;

    User updateResume(String username) throws Exception;

    void update(User user) throws Exception;

    List<PersonAffairs> findMyAffair(Map<String, Object> map) throws Exception;

    int findMyAffairCount(String name) throws Exception;

    void updatePicture(Map<String,Object> map) throws Exception;

    List<UploadFile> findMyUploadFile(Map<String, Object> map) throws Exception;

    int findMyUploadFileCount(String user) throws Exception;
}
