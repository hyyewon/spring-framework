package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//target인 UserService의 sayEcho()메서드 호출시 위빙되는 aspect 객체
@Aspect
public class AfterThrowingAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {	}
	
	//sayEcho() 호출해서 예외가 발생했을 때만 위빙된다.
	//throwing 속성은 sayEcho()메서드에서 예외가 발생했을 때 예외를 저장할 변수를 지정 catch(Exception e)
	@AfterThrowing(pointcut="xxx()", throwing="e")
	public void method2(Exception e) { //Object xxx에는 호출되는 메서드(sayEcho)가 리턴하는 값이 저장됨
		System.out.println("AfterThrowingAspect.method2>>"+e.getMessage());
	}
	
//	//advise + pointcut 같이 표현
//	@AfterReturning(pointcut="execution(* callEcho(..))",returning="yyy") //callEcho() 호출 후에 위빙됨
//	public void method3(JoinPoint point, Object yyy) { 
//		System.out.println("호출한 핵심기능 메서드명:"+point.getSignature().getName()); //핵심기능 메서드명을 알 수 있음
//		System.out.println("AfterAspect.method3>>"+yyy);
//	}

}
