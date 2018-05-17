package edu.cqut.llj.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.cqut.llj.exception.GirlException;

@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@SuppressWarnings("unused")
	@ExceptionHandler(value=Exception.class)
	public String handle(Exception e){
		if(e instanceof GirlException){
			GirlException girlException = (GirlException) e;
			return "html/login";
		}else{
			LOGGER.error("【系统异常】{}",e);
			return "html/error";
		}
	}
}
