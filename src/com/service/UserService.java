package com.service;

import com.entity.PersonAffairs;
import com.entity.UploadFile;
import com.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    User login(String username,String password) throws Exception;
    int regist(User user) throws Exception;
    User usernameCheck(String username) throws Exception;

    User updateResume(String username) throws Exception;

    int update(User user) throws Exception;

    List<PersonAffairs> findMyAffair(HttpSession session,int page, int limit) throws Exception;

    int findMyAffairCount(HttpSession session) throws Exception;

    void updatePicture(String pictureAddress,String username) throws Exception;

    List<UploadFile> findMyUploadFile(int page, int limit) throws Exception;

    int findMyUploadFileCount() throws Exception;
}
