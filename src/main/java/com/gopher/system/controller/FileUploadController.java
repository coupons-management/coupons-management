package com.gopher.system.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gopher.system.controller.model.Result;

@Controller
@RequestMapping(path="/file")
public class FileUploadController {
	@RequestMapping(value="/upload",method=RequestMethod.POST)
    public Result fildUpload(@RequestParam(value="file",required=false) MultipartFile file,
            HttpServletRequest request)throws Exception{
        //获得物理路径webapp所在路径
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/static/images/"+imageName+"."+uuid;
            file.transferTo(new File(pathRoot+path));
        }
        Result result = new Result();
        result.setData(path);
        return result;
    }
}
