package kr.co.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {
	
	// 생성자 DI
	private CPU cpu; // 참조변수는 선언만 한다고 사용할 수 x; 먼저 초기화해야 함(이 경우 자바에서는 생성자를 통해서)
	
	@Autowired
	public Computer(CPU cpu) {
		this.cpu = cpu;
	}
	
	// 세터 DI
	private RAM ram;
	
	@Autowired
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
	// 필드 DI
	@Autowired
	private HDD hdd;
	
	public void show() {
		cpu.show();
		ram.show();
		hdd.show();
	}
}
