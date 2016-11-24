package name.qiu.thread;

public class MyThread extends Thread{
	
	public void run()
	{
		System.out.println("Throwing in MyThread");
		throw new RuntimeException();
	}
	
	
}
