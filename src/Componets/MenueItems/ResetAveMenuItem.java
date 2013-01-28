package Componets.MenueItems;

import javax.swing.JMenuItem;
import Parsers.Parsing;

public class ResetAveMenuItem extends JMenuItem
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5037672022705268933L;
	private boolean actionListenerSet = false;

	
	public ResetAveMenuItem()
	{
		super("Reset Ave");	
		this.setName("Reset Ave");
	}
	
	public void setActionListener (Parsing parsing)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new ResetAveMenuItemActionListener(parsing));
			actionListenerSet = true;
		}
	}

}
