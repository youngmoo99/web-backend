package test;

//Thread 클래스를 상속받아서 counterThread를 만듬
public class starThread extends Thread{ //메서드가 여러개 
	//동시에 처리하고 싶은 내용이 있으면, Thread가 가지는 메서드 중 run()를 재정의 
	
	@Override
	public void run() {
		for (int i = 500; i > 0; i--) {
			String star = "*";
			System.out.println("카운터>>"+ star);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 0.5초 
		}
	}

}
