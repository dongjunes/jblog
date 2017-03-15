package com.bit2017.jblog.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log LOG = LogFactory.getLog( GlobalExceptionHandler.class );
	
	@ExceptionHandler(Exception.class)
	public String handlerException(Exception e){
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		LOG.error(errors.toString());
		return "error/exception";
	}
	
	
}
