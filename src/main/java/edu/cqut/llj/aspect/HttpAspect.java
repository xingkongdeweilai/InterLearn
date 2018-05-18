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

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.exception.GirlException;

@Aspect
@Component
/**
 * 面向切面
 * @author Administrator
 *
 */
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * edu.cqut.llj.controller.WordController.*(..))")
	public void log(){
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = attributes.getRequest();
		//登录账户
		try {
			logger.info(req.getSession().getAttribute("user").toString());
		} catch (NullPointerException e) {
			throw new GirlException(ResultEnum.USER_LOGIN_NULL);
		}
		
		//url
		logger.info("url={}",req.getRequestURL());
		//method
		logger.info("method={}",req.getMethod());
		//ip
		logger.info("ip={}",req.getRemoteAddr());
		//类方法
		logger.info("class_metho={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		logger.info("args={}",joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter(){
		logger.info("222222222");
	}
	
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object){
		if(object!=null){
			logger.info("response={}", object.toString());
		}
	}
}
