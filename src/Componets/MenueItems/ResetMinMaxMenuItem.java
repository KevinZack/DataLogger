package Componets.MenueItems;

import javax.swing.JMenuItem;
import Gui.Window;

public class ResetMinMaxMenuItem extends JMenuItem
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8203854725867137698L;
	private boolean actionListenerSet = false;

	
	public ResetMinMaxMenuItem()
	{
		super("Reset Min/Max");	
		this.setName("Reset Min/Max");
	}
	
	public void setActionListener (Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new ResetMinMaxMenuItemActionListener(window));
			actionListenerSet = true;
		}
	}

}
