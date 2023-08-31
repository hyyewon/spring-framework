package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//target인 UserService의 sayEcho()메서드 호출시 위빙되는 aspect 객체
@Aspect
public class AroundAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {	}
	
	//sayEcho() 호출해서 호출전,후,정상적으로 리턴,예외발생시 모두 위빙된다.
	@Around(value = "xxx()")
	public Object method2(ProceedingJoinPoint pjp)throws Throwable { //afterThrowing 역할
		System.out.println("AroundAspect.method2>>");
		System.out.println("before advice 역할");
		Object xxx = pjp.proceed(); //pjp.proceed()메서드가 sayEcho() 호출하고 리턴값을 xxx에 저장
		System.out.println("after advise 역할");
		System.out.println("afterReturning 역할" + xxx);
		
		return "홍"; //sayEcho() 호출한 곳으로 리턴. main에서 받음.
	}
	
//	//advise + pointcut 같이 표현
//	@AfterReturning(pointcut="execution(* callEcho(..))",returning="yyy") //callEcho() 호출 후에 위빙됨
//	public void method3(JoinPoint point, Object yyy) { 
//		System.out.println("호출한 핵심기능 메서드명:"+point.getSignature().getName()); //핵심기능 메서드명을 알 수 있음
//		System.out.println("AfterAspect.method3>>"+yyy);
//	}

}
