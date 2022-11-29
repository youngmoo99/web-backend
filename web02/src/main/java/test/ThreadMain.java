package test;

public class ThreadMain {

	public static void main(String[] args) {
		// 스레드 객체 3개 
		CounterThread counter = new CounterThread();
		imgThread img = new imgThread();
		TimerThread timer = new TimerThread();
		
		counter.start();
		img.start();
		timer.start();
	}

}
