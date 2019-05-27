package com.gopher.system.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Aspect
@Component
public class ParamAspect {
	private static final Logger log = LoggerFactory.getLogger(ParamAspect.class);

	@Pointcut("execution(public * com.gopher.system.service.*.*(..))")
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
		log.info("========================================================");
		this.doParamLog(joinPoint);
		
		return joinPoint.proceed();
	}

	private ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

	void doParamLog(ProceedingJoinPoint joinPoint) {

		// 获得切入的方法签名
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		// 获得切入的方法
		Method method = signature.getMethod();

		// 获取切入方法参数值
		Object[] argValues = joinPoint.getArgs();
		log.debug("请求参数：{}", JSON.toJSONString(argValues));
		// 获取切入方法参数名称
//		String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);

		// 获取切入方法参数类型
		Class[] parameterTypes = signature.getParameterTypes();
		// ############################# LOGGING STARTING
		// #############################################
		if (log.isDebugEnabled()) {
			log.debug("方法签名：{}", signature.toShortString());
		}

//		StringBuilder paramsBuilder = new StringBuilder();
//		if(null == parameterNames) {
//			log.info("没有参数");
//			return;
//		}
//		int paramNamesLength = parameterNames.length;
//		if (paramNamesLength != 0) {
//			for (int i = 0; i < paramNamesLength; i++) {
//				paramsBuilder.append(parameterNames[i]).append("(").append(parameterTypes[i].getSimpleName())
//						.append(")").append(" = ").append(argValues[i]).append(", ");
//			}
//		}
//		if (log.isDebugEnabled()) {
//			log.debug("请求参数: [{}]", paramsBuilder.toString());
//		}

		// ############################# LOGGING ENDING
		// #############################################
	}

}
