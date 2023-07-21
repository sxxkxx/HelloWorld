package co.yedam.collect;

public class Box<T> { // <T> : 변수를 선언할때 타입지정.
	T obj; // 최상위객체 모든타입 저장가능.

	void set(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}
