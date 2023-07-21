package co.yedam.collect;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueExe {

	public static void main(String[] args) {
		Queue<String> que = new LinkedBlockingDeque<>();
		que.offer("son");
		que.offer("kim");
		que.offer("lee");
		
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}

}
