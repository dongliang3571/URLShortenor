package org.dong.demo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		;
		return "Hi" + (new Triangle(5)).toString(); 
	}
}

class Triangle {
	private final int i;
	
	public Triangle(int i) {
		this.i = i;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.i);
	}
}