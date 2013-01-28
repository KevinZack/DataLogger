package Componets.MenueItems;

import javax.swing.JMenuItem;

import Gui.Window;

public class DecimalPacesMenuItem extends JMenuItem
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5720588637541496364L;
	private boolean actionListenerSet = false;

	
	public DecimalPacesMenuItem(String number)
	{
		super(number);
	}
	
	public void setActionListener (int places, Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new DecimalPlacesMenuItemActionListener(places,window));
			actionListenerSet = true;
		}
	}

}
