package Connection;

import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Main.DataManager;


public class SocketConnection 
{
	private int port = 2000;
	private Socket socket;
	private ServerSocket serverInSocket;
	public SerialPort serialPort = null; // other choice using other class. nessisary to pass null
	private InputStream inputStream;
	
	public SocketConnection(DataManager dataManager)
	{
		try {
			serverInSocket = new ServerSocket(port);
			socket = serverInSocket.accept();
			inputStream = socket.getInputStream();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		dataManager.initializeSocket(socket, inputStream);
	}

}
