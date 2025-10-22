package com.xq.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class FileController {

    //文件下载
    @RequestMapping("download")
    public ResponseEntity<byte[]> downloadFile(HttpSession session) throws IOException {
        //获取servletContext对象
        ServletContext servletContext = session.getServletContext();
        //根据servletContext对象获取文件真实路径
        String realPath = servletContext.getRealPath("/images/audiA8.jpg");
        System.out.println(realPath);
        //获取输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组对象
        byte[] bytes = new byte[is.available()];
        //将数据读取到数组中
        is.read(bytes);
        //设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=car.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭流
        is.close();
        return responseEntity;
    }

    /*//基于servlet进行文件上传
    @RequestMapping("upload")
    public String uploadFile(HttpServletRequest request) throws Exception {
        //获取文件上传的目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        //根据文件路径创建file对象 如果不存在则自动创建
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //根据磁盘文件项工厂创建上传文件对象
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //根据ServletFileUpload解析对象上传请求 获取FileItem对象的集合
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem item : fileItems) {
            if (item.isFormField()) {
                //普通表单 不做任何处理
                System.out.println("普通表单");
            }else{
                //获取文件名
                String fieldName = item.getName();
                //执行文件上传操作
                item.write(new File(path,fieldName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }*/

    @RequestMapping("upload")
    public String uploadFile(HttpServletRequest request, MultipartFile upload) throws Exception {
        //获取文件上传的目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        //根据文件路径创建file对象 如果不存在则自动创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件上传的名称
        String filename = upload.getOriginalFilename();
        //执行文件上传的操作
        upload.transferTo(new File(path,filename));
        return "success";
    }

}
