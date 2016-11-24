package name.qiu.thread;

/**
 * 并行抓取 稳定性测试
 * @author qiu
 * 2016年11月22日
 */
public class ThreadTest {
	
	/**
	 * 设计思路：
	 * 下载网页时，经常会出现异常。有些异常无法捕获，导致爬虫程序退出。
	 * 为了主程序稳定，把下载程序放在子线程执行
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyThread t = new MyThread();
		t.start();
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			System.out.println("Caught it");
		}
		
		System.out.println("Exiting main");
	}
}
