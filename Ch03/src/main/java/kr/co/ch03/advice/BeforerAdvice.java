package kr.co.ch03.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 부가기능이 있는 경우 사용하는 annotation
@Component
public class BeforerAdvice {
	
	@Pointcut("execution(* kr.co.ch03.AOPService.insert*(..))") // 반환형은 모두(첫번째 *) 해당 패키지, 클래스의 insert로 시작하는 모든 메서드(두번째 *)의 매개변수(..); 매개변수 개수가 제한 없다는 뜻(0개부터 가능)
	public void insertPointcut() {}
	
	@Pointcut("execution(* kr.co.ch03.AOPService.select*(..))")
	public void selectPointcut() {}
	
	@Pointcut("execution(* kr.co.ch03.AOPService.update(..))")
	public void updatePointcut() {}
	
	@Before("insertPointcut()") // 부가기능 annotation의 한 종류
	public void before1() {
		System.out.println("횡단관심 - before1"); // 횡단관심은 부가기능을 뜻함
	}
	@Before("selectPointcut()")
	public void before2() {
		System.out.println("횡단관심 - before2");
	}
	@Before("updatePointcut()")
	public void before3() {
		System.out.println("횡단관심 - before3");
	}
}
