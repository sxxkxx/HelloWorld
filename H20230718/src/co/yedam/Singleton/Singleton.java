package co.yedam.Singleton;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	// 외부에서 접근불가.
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}
