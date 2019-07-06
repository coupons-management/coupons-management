package com.gopher.system.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 
     * @param file 
     * @return 返回文件路径
     */
	 String upload(MultipartFile file);

}
