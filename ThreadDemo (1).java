public class ThreadDemo extends Thread
{
	public void demo()
	{
		Thread t=new Thread(this);
		t.start();
		System.out.println(t);
	}

	public void run()
	{
		System.out.println("thread is running");
	}

	public static void main(String args[])
	{
		ThreadDemo obj=new ThreadDemo();
		obj.demo();
	}
}