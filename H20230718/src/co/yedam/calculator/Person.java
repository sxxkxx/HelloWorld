package co.yedam.calculator;

public class Person {
	String name;
	int age;
	double height;

	int sum(int n1, int n2) {
//		Calculator cal = new Calculator();
//		return cal.add(n1, n2);
		return Calculator.add(n1, n2); //정적 메소드
	}
	
	// 기본생성자 :자바 컴파일러가 생성. 
	Person(){
		
	}
}
