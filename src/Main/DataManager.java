package Main;

import java.io.InputStream;
import java.net.Socket;
import java.lang.Math;
import gnu.io.SerialPort;
import Connection.ConnectArduino;
import Connection.SocketConnection;
import Events.CompleteRecieveEvent;
import Events.ICompleteRevieveEventListener;
import Events.IPayloadUpdateUpdateGraphEventListener;
import Gui.AttemptingSocket;
import Parsers.Parsing;

public class DataManager extends Thread
{
	public String com;
	public ConnectArduino connectArduino;
	public SocketConnection socketConnection;
	public SerialPort serialPort;
	private InputStream inputStream;
	public boolean connected = true;
	public boolean emulator = false;
	public String inputString;
	public Parsing parsing;
	public static javax.swing.event.EventListenerList listenerList = new javax.swing.event.EventListenerList();
	
	public String finalString = "";
	public String addString = "";
	public String middleString = "";
	public String tempString = "";
	public double startTime = System.currentTimeMillis();
	public double time = 0;
	public double yValue = 0.0;
	public int count = 0;
	
	public DataManager(String com, int connectionType, AttemptingSocket attempting)
	{
		this.com = com;
		if(connectionType == 0)
		{
			connectArduino = new ConnectArduino(this, com);
		}
		if(connectionType == 1)
		{
			socketConnection = new SocketConnection(this);
			attempting.frame.setVisible(false);
		}
		if(connectionType ==2)
		{
			initializeEmulator();
		}

	}
	public void initializeSerial(SerialPort serialPort, InputStream input )
	{
		this.serialPort = serialPort;
		this.inputStream = input;
		this.start();

		parsing = new Parsing();
	}
	
	public void initializeSocket(Socket socket, InputStream input )
	{
		this.inputStream = input;
		this.start();

		parsing = new Parsing();
		
	}
	
	public void initializeEmulator()
	{
		emulator = true;
		parsing = new Parsing();
		this.start();
	}
	
	public void run()
	{
		if(!emulator)
		{
			while(connected)
			{
				try 
				{
					int available = inputStream.available();
					if(available >= 0)
					{
						byte chunk[] = new byte[available];
		
						inputStream.read(chunk, 0, available);
						inputString = new String(chunk);
						
			    		CompleteRecieveEvent complete = new CompleteRecieveEvent(this, inputString);
			    		Object[] listeners = DataManager.listenerList.getListenerList(); 
			       		for (int i=0; i<listeners.length; i+=2) 
			       		{
			                 if (listeners[i]==ICompleteRevieveEventListener.class)
			                 {
			                     ((ICompleteRevieveEventListener)listeners[i+1]).CompleteRevieveEventHandler(complete);
			                 }
			            } 		
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
		else
		{
			while(connected)
			{
				time = System.currentTimeMillis() - startTime;
				count++;
				yValue = Math.sin(count*.1);
				
				inputString = "@,";
				inputString += time;
				inputString += ",";
				inputString += yValue;
				inputString += ",#";
				
				CompleteRecieveEvent complete = new CompleteRecieveEvent(this, inputString);
	    		Object[] listeners = DataManager.listenerList.getListenerList(); 
	       		for (int i=0; i<listeners.length; i+=2) 
	       		{
	                 if (listeners[i]==ICompleteRevieveEventListener.class)
	                 {
	                     ((ICompleteRevieveEventListener)listeners[i+1]).CompleteRevieveEventHandler(complete);
	                 }
	            } 		
				try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}
	
	
	public static void addPayloadUpdateEvent (IPayloadUpdateUpdateGraphEventListener completePayloadUpdateEventListener)
	{
		listenerList.add(IPayloadUpdateUpdateGraphEventListener.class, completePayloadUpdateEventListener);
	}
	public static void removePayloadUpdateEvent (IPayloadUpdateUpdateGraphEventListener completePayloadUpdateEventListener)
	{
		listenerList.remove(IPayloadUpdateUpdateGraphEventListener.class, completePayloadUpdateEventListener);
	}
	public static void addCompleteRevieveEvent (ICompleteRevieveEventListener completeRevieveEventListener)
	{
		listenerList.add(ICompleteRevieveEventListener.class, completeRevieveEventListener);
	}
}
