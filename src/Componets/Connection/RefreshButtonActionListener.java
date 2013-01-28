package Componets.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.Connect;

public class RefreshButtonActionListener implements ActionListener
{
	private Connect connect;
	
	public RefreshButtonActionListener (Connect connect)
	{
		this.connect = connect;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		connect.comboBox.removeAllItems();
		connect.comList.removeAllElements();
		connect.getCom();
		 
	}
}
