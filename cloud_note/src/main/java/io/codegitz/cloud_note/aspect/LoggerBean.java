package io.codegitz.cloud_note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerBean {

	@Before("within(io.codegitz.cloud_note.controller..*)")
	public void logController(){
		System.out.println("AOP注入成功");
	}
	
	@Before("within(io.codegitz.cloud_note.service..*)")
	public void logService(){
		System.out.println("AOP注入service");
	}
}
