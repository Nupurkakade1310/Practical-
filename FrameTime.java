import java.awt.*;
import java.util.*;
public class FrameTime extends Frame implements Runnable
{
	Thread t;
	String msg;
	
	public FrameTime()
	{
		msg=" ";
		t=new Thread(this);
		t.start();
	}

	public void run()
	{	
		for(;;)
		{
			try
			{
				GregorianCalendar cal=new GregorianCalendar();
				msg=cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
				t.sleep(1000);
				repaint();
			}
			catch(InterruptedException e)
			{
				System.out.println("interrupted");
			}
		}
	}	

	public void paint(Graphics g)
	{
		g.drawString(msg,40,140);
	}

	public static void main(String args[])
	{
		FrameTime ft=new FrameTime();
		ft.setSize(400,400);
		ft.setVisible(true);
	}
}