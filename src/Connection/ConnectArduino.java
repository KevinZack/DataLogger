package Connection;

import Main.DataManager;
import java.io.InputStream;
import java.net.Socket;
import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class ConnectArduino 
{
	public SerialPort serialPort;
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 14400;
	private InputStream input;
	public static javax.swing.event.EventListenerList listenerList = new javax.swing.event.EventListenerList();
	public String inputString;
	public String com;
	public Enumeration<CommPortIdentifier> portList;
	public CommPortIdentifier currPortId;
	public DataManager dataManager;
	public Socket socket = null;
	
	public ConnectArduino(DataManager dataManager, String com)
	{
		this.com = com;
		this.dataManager = dataManager;
		setCom();
		initialize();
	}
	
	@SuppressWarnings("unchecked")
	public void setCom()
	{
		 portList = CommPortIdentifier.getPortIdentifiers();
		 boolean morePorts = true;
		 
		 while(morePorts)
		 {
			CommPortIdentifier portElement = (CommPortIdentifier) portList.nextElement();
			
			if(portElement.getName().equals(com))
			{
				currPortId = portElement;
				morePorts = false;
			}
			
			 if(!portList.hasMoreElements())
			 {
				 morePorts = false;
			 } 
		 }
	}
	
	
	public void initialize() 
	{

		try 
		{
			serialPort = (SerialPort) currPortId.open(this.getClass().getName(),TIME_OUT);


			serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			input = serialPort.getInputStream();
			serialPort.getOutputStream();
			
		} 
		catch (Exception e) 
		{
			System.err.println(e.toString());
		}
		
		dataManager.initializeSerial(serialPort, input);
	}
}
