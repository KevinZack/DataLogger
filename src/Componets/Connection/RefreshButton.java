package Componets.Connection;

import javax.swing.JButton;

import Gui.Connect;

public class RefreshButton extends JButton 
{
	private static final long serialVersionUID = -6429240007417074059L;
	private boolean actionListenerSet = false;
	private Connect connect;
	
	public RefreshButton(Connect connect)
	{
		super("Refresh");	
		this.connect = connect;
	}
	
	public void setActionListener ()
	{
		if(!actionListenerSet)
		{
			this.addActionListener(new RefreshButtonActionListener(connect));
			actionListenerSet = true;
		}
	}
}