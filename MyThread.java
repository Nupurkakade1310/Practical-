public class MyThread implements Runnable
{
	Thread t;
	public MyThread()
	{
		t=new Thread(this);
		t.start();
	}

	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
			try
			{
				Thread.sleep(2000);
				System.out.println(t.isAlive());
			}
			catch(InterruptedException e)
			{
				System.out.println("Thread interrupted");
			}
		}
	}

	public static void main(String args[])
	{
		MyThread mt=new MyThread();
	}
}