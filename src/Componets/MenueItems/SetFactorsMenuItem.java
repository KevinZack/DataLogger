package Componets.MenueItems;

import javax.swing.JMenuItem;

import Gui.Window;
import Parsers.Parsing;

public class SetFactorsMenuItem extends JMenuItem
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7985068141906725298L;
	private boolean actionListenerSet = false;
	
	public SetFactorsMenuItem()
	{
		super("Set Factors");	
	}

	public void setActionListener (Parsing parsing, Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new SetFactorsMenuItemActionListener(parsing, window));
			actionListenerSet = true;
		}
	}
}
