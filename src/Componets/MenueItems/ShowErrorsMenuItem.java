package Componets.MenueItems;

import javax.swing.JMenuItem;

import Gui.Window;
import Parsers.Parsing;

public class ShowErrorsMenuItem extends JMenuItem
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7985068141906725298L;
	private boolean actionListenerSet = false;
	
	public ShowErrorsMenuItem()
	{
		super("Show Error Data");	
	}

	public void setActionListener (Parsing parsing, Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new ShowErrorsMenuItemActionListener(parsing, window));
			actionListenerSet = true;
		}
	}
}
