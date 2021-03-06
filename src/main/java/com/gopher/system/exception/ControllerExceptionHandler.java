package com.gopher.system.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gopher.system.constant.CodeAndMsg;
import com.gopher.system.controller.model.Result;
	
@RestControllerAdvice( value = {"com.gopher.system.controller"})
public class ControllerExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	@ExceptionHandler(value = { BusinessRuntimeException.class })
	public Result businessException(BusinessRuntimeException e) {
		LOG.error(e.getMessage(), e);
		return new Result(e.getCode(), e.getMessage(), false);
	}

	@ExceptionHandler(value = { Exception.class })
	public Result unknownException(Exception e) {
		LOG.error(e.getMessage(), e);
		return new Result(CodeAndMsg.SYSTEM_EXCEPTION.getCode(),"系统繁忙,请联系管理员或稍后再试!", false);
	}
}