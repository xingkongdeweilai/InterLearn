package edu.cqut.llj.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
/**
 * 面向切面
 * @author Administrator
 *
 */
public class HttpAspect {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * edu.cqut.llj.controller.GirlController.*(..))")
	public void log(){
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = attributes.getRequest();
		//url
		LOGGER.info("url={}",req.getRequestURL());
		//method
		LOGGER.info("method={}",req.getMethod());
		//ip
		LOGGER.info("ip={}",req.getRemoteAddr());
		//类方法
		LOGGER.info("class_metho={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		LOGGER.info("args={}",joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter(){
		LOGGER.info("222222222");
	}
	
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object){
		LOGGER.info("response={}", object.toString());
	}
}
