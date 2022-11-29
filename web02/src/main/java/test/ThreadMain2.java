package test;

public class ThreadMain2 {

	public static void main(String[] args) {
		// 스레드 객체 3개 
		starThread star = new starThread();
		dollarThread dollar = new dollarThread();
		bangThread bang = new bangThread();
		
		
		star.start();
		dollar.start();
		bang.start();
	}

}
