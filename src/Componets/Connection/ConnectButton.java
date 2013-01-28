package Componets.Connection;

import javax.swing.JButton;
import Gui.Connect;

public class ConnectButton extends JButton 
{
	private static final long serialVersionUID = -6429240007417074059L;
	private boolean actionListenerSet = false;
	private Connect connect;
	
	public ConnectButton(Connect connect)
	{
		super("Connect");	
		this.setName("ConnectButton");
		this.connect = connect;
	}
	
	public void setSerialActionListener ()
	{
		if(!actionListenerSet)
		{
			this.addActionListener(new ConnectSerialActionListener(this,connect));
			actionListenerSet = true;
		}
	}
	public void setSocketActionListener ()
	{
		if(!actionListenerSet)
		{
			this.addActionListener(new ConnectSocketActionListener(this,connect));
			actionListenerSet = true;
		}
	}
}