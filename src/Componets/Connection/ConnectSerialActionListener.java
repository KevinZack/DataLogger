package Componets.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Gui.AttemptingSocket;
import Gui.Connect;
import Main.DataManager;

public class ConnectSerialActionListener implements ActionListener
{
	private Connect connect;
	private String com;
	private AttemptingSocket atempt;
	
	public ConnectSerialActionListener (JButton connectButton, Connect connect)
	{
		this.connect = connect;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{

		com = connect.comboBox.getSelectedItem().toString();
		if(!connect.comboBox.getSelectedItem().toString().equals("NA"))
		{	
			connect.frame.setVisible(false);
			new DataManager(com,0, atempt);		
		}
		 
	}
}
