package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.utils.DownLoadUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

@RestController
public class FileDownloadController {

    //文件下载
    @RequestMapping("filedownload.do")
    public void singDownload(HttpServletRequest request, HttpServletResponse response, String file) throws IOException {
//        获取文件名
//        获取文件在项目中的具体路径
        String filename = new String(file.getBytes("ISO-8859-1"),"UTF-8");
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("download/" + filename);
//        创建输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
//        通知浏览器不要解析直接下载
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
//        适配浏览器
        String agent = request.getHeader("User-Agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition", "attachment;filename=" + filename);
//      获取输出流对象
        OutputStream outputStream = response.getOutputStream();
//      边读边写
        int len = 0;
        byte[] bytes = new byte[1024 * 1024 * 10];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
//      释放资源
        fileInputStream.close();
        outputStream.close();
    }


    //多文件下载
    @RequestMapping("downloadList.do")
    public JSONObject downloadList(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("download/education");
        File file = new File(realPath);
        File[] list = file.listFiles();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ArrayList<String> lista = new ArrayList<>();
        for (File f : list) {
            String name = f.getName();
            //对内容使用url编码 编码之后的内容ie可以解析
            String encodeName = URLEncoder.encode(name, "utf-8");
            lista.add(name);
        }
        JSONObject json = new JSONObject();
        json.put("data",lista);
        return json;
    }

    @RequestMapping("download.do")
    public void download(HttpServletRequest request, HttpServletResponse response,String file) throws IOException {
//        获取文件名
//        获取文件在项目中的具体路径
        String filename = new String(file.getBytes("ISO-8859-1"),"UTF-8");

        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("download/education/" + filename);
//        创建输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
//        通知浏览器不要解析直接下载
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
//        适配浏览器
        String agent =request.getHeader("User-Agent");
        filename = DownLoadUtils.getFileName(agent , filename);
        response.setHeader("content-disposition", "attachment;filename=" + filename);
//      获取输出流对象
        OutputStream outputStream = response.getOutputStream();
//            边读边写
        int len = 0;
        byte[] bytes = new byte[1024 * 1024 * 10];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
//        释放资源
        fileInputStream.close();
        outputStream.close();
    }


}
