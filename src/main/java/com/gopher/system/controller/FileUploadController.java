package com.gopher.system.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gopher.system.controller.model.Result;
import com.gopher.system.service.impl.LoginServiceImpl;
/**
 * 文件上传
 * @author dongyangyang
 *
 */
@RestController
@RequestMapping(path="/file")
public class FileUploadController {
	/*private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Value(value="${file.basePath}")
	private String basePath;
	@Value(value="${file.baseUrl}")
	private String baseUrl;
	@RequestMapping(value="/upload",method=RequestMethod.POST)
    public Result fildUpload(@RequestParam(value="file",required=false) MultipartFile file,
    		ServletRequest servletRequest)throws Exception{
		logger.info(basePath);
        String fileName = file.getOriginalFilename();
        if(StringUtils.hasText(fileName)){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid+"_"+fileName;
            file.transferTo(new File(basePath+fileName));
        }
        Result result = new Result();
        // 返回文件的网路地址
        result.setData(baseUrl+fileName);
        return result;
    }*/
}
