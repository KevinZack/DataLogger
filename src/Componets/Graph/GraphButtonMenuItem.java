package Componets.Graph;

import javax.swing.JMenuItem;

import Gui.Window;


public class GraphButtonMenuItem extends JMenuItem 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4757404618347565907L;
	

	boolean actionListenerSet = false;
	public String graphName;
	public int sensorNubmer;
	
	public GraphButtonMenuItem(String graphName)
	{
		super(graphName);	
	}	
	
	public void setActionListener(Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new GraphMenuItemActionListener(window));
			actionListenerSet = true;
		}
	}

}
