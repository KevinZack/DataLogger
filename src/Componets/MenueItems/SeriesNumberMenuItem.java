package Componets.MenueItems;

import javax.swing.JMenuItem;
import Gui.CreateGraph;

public class SeriesNumberMenuItem extends JMenuItem
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5720588637541496364L;
	private boolean actionListenerSet = false;

	
	public SeriesNumberMenuItem(String number)
	{
		super(number);
	}
	
	public void setActionListener (CreateGraph createGraph,int number)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new SeriesNumberMenuItemActionListener(createGraph,number));
			actionListenerSet = true;
		}
	}

}
