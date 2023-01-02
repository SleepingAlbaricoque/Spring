package kr.co.ch02;

import org.springframework.stereotype.Component;

@Component //application.xml bean 태그로 저장하지 않아도 이 annotation + application.xml(컨테이너 설정 파일)에서 스캔으로 컨테이너에 바로 저장 가능
public class Speaker {
	
	public void soundUp() {
		System.out.println("Speaker volumeUp");
	}
	public void soundDown() {
		System.out.println("Speaker volumeDown");
	}
}
