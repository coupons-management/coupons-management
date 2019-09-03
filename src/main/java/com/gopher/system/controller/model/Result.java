package com.gopher.system.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回结果")
public class Result {

    @ApiModelProperty(value = "返回码")
    private int code;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "请求是否成功")
    private boolean success= true;

    @ApiModelProperty(value = "返回数据")
    private Object data;
    
    public Result(){
    	this.code = 0;
    	this.message = "请求成功";
    }
    
    public Result(Object data){
    	this.code = 0;
    	this.message = "请求成功";
    	this.data = data;
    }
    
    public Result(int code,String message,boolean success){
    	this.code = code;
    	this.message = message;
    	this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
