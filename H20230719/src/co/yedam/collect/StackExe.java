package co.yedam.collect;

import java.util.Stack;

public class StackExe {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("son");
		stack.push("kim");
		stack.push("lee");

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());  // pop: 스택 최상단값 출력후 제거
//			System.out.println(stack.peek()); // peek: 스택 최상단값 출력
		}
	}
}
