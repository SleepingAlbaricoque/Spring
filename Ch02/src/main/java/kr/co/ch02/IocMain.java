package kr.co.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2023.01.02 
 * 이름 : 조수빈
 * 내용 : 스프링 IoC 실습하기
 * 
 * IoC(Inversion of Control)
 * - 자바 객체를 생성하고 객체 사이의 의존관계를 스프링 컨테이너로 처리하는 개념
 * - DI(Dependency Injection)는 IoC 구현하는 기술
 * - DI 기법 중 Annotation 방식을 일반적으로 사용
 */

public class IocMain {
	public static void main(String[] args) {
		
		// IoC를 활용하지 않는 객체 생성
		TV t1 = new LgTV(); // 여기서 TV는 t1 변수의 자료형일뿐, cannot be instantiated like LgTv gets instantiated here
		TV t2 = new SamsungTV();
		
		t1.powerOn();
		t1.chUp();
		//t1.soundUp(); 객체를 직접 생성하는 방식이라 LgTV에 주입한 객체의 메서드는 여기서 사용하지 못함
		
		t2.powerOn();
		t2.chUp();
		//t2.soundUp();
		
		// ctx가 바로 container in which objects get created and stored -> the container injects those objects into a new object(bean)
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		TV ltv = (TV) ctx.getBean("ltv"); // application.xml에서 지정한 bean id를 getBean()의 argument로
		TV stv = (TV) ctx.getBean("stv");
		
		ltv.powerOff();
		ltv.chDown();
		ltv.soundDown();
		
		stv.powerOff();
		stv.chDown();
		stv.soundDown();
	}
}
