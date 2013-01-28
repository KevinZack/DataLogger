package Componets.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Gui.AttemptingSocket;
import Gui.Connect;

public class ConnectSocketActionListener implements ActionListener
{
	private Connect connect;
	public ConnectSocketActionListener (JButton connectButton, Connect connect )
	{
		this.connect = connect;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println("Attempting Socket Conenction");
		connect.frame.setVisible(false);
		new AttemptingSocket();
			
		
		 
	}
}
