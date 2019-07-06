package com.gopher.system.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author dongyangyang
 * HTTP 接口参数打印
 */
@Aspect
@Component
public class ParamAspect {
	private static final Logger log = LoggerFactory.getLogger(ParamAspect.class);

	@Pointcut("execution(public * com.gopher.system.controller.*.*(..)) && !execution(* com.gopher.system.controller.FileUploadController.*(..))")
	public void paramFilter() {

	}

	/**
	 *     环绕
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("paramFilter()")
	private Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		this.doParamLog(joinPoint);
		Object result = joinPoint.proceed();
		return result;
	}

	void doParamLog(ProceedingJoinPoint joinPoint) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获得切入的方法签名
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// 获取切入方法参数值
		Object[] argValues = joinPoint.getArgs();
		log.info("请求参数：{}", JSON.toJSONString(argValues));
		// 获取切入方法参数名称
		log.info("方法签名：{}", signature.toShortString());
		// 避免通过单元测试直接调用controller方法报错
		if(null != request) {
			log.info("请求URL:{}",request.getRequestURL());
		}
	}

}
