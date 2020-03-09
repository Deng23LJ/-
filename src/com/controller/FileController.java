package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;
import com.utils.AppFileUtils;
import com.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.utils.AppFileUtils;
import com.utils.RandomUtils;

/**
 * 文件上传
 *
 * @author LJH
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private UserService userService;
    /**
     * 文件上传
     * 上传一个文件保存到E://upload
     *
     * @throws IOException
     */
    private String pictureAddress = null;
    @RequestMapping("upload.do")
    @ResponseBody
    public Map<String, Object> upload03(HttpSession session,MultipartFile mf) throws Exception {
//        System.out.println(mf);
//        System.out.println(mf.getContentType());//文件的类型
//        System.out.println(mf.getName());//表单的name属性值
//        System.out.println(mf.getOriginalFilename());//文件名
//        System.out.println(mf.getSize());//文件大小
//        System.out.println(mf.getInputStream());//文件流
        //文件上传的父目录
        String parentPath = AppFileUtils.PATH;
        //得到当前日期作为文件夹名称
        String dirName = RandomUtils.getCurrentDateForString();
        //构造文件夹对象
        File dirFile = new File(parentPath, dirName);
        if (!dirFile.exists()) {
            dirFile.mkdirs();//创建文件夹
        }
        //得到文件原名
        String oldName = mf.getOriginalFilename();
        //根据文件原名得到新名
        String newName = RandomUtils.createFileNameUseTime(oldName);
        //获取图片路径（绝对路径）
        pictureAddress = "D:/毕业设计/前台/ssm/web/upload/"+dirName+"/"+newName;
        //修改数据库
        String username = (String) session.getAttribute("name");
        System.out.println(pictureAddress);
        userService.updatePicture(pictureAddress,username);
        //-------------
        File dest = new File(dirFile, newName);
        mf.transferTo(dest);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        Map<String, Object> data = new HashMap<>();
        data.put("src", "file/downloadFile.do?path=" + dirName + "/" + newName);
        map.put("data", data);
        return map;
    }

    /**
     * 下载的方法
     */
    @RequestMapping("downloadFile")
    public ResponseEntity<Object> downloadFile(String path, HttpServletResponse response) {
        //3,拿到文件的老名字
        return AppFileUtils.downloadFile(response, path, "");
    }


}
