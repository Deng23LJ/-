package com.controller.FIleDeal;

import com.controller.FIleDeal.DownLoadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@Controller
public class FileDownloadController {

    //    文件下载
    @RequestMapping("filedownload.do")
    public void singDownload(HttpServletRequest request, HttpServletResponse response,String filename) throws IOException {
//        获取文件名
//        获取文件在项目中的具体路径
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("download/" + filename);
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



    @RequestMapping("downloadList.do")
    public void downloadList(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("download");
        File file = new File(realPath);
        File[] list = file.listFiles();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        for (File f : list) {
            String name = f.getName();
            //对内容使用url编码 编码之后的内容ie可以解析
            String encodeName = URLEncoder.encode(name, "utf-8");
            System.out.println(encodeName);
            response.getWriter().write("<a href='filedownload.do?filename="+encodeName+"'>"+name+"</a><br/>");
        }

    }
}
