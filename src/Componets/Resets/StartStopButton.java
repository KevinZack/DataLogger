package Componets.Resets;

import javax.swing.JToggleButton;
import Gui.Window;

public class StartStopButton extends JToggleButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7342826155675715442L;
	private boolean actionListenerSet = false;
	
	public StartStopButton()
	{
		super();	
	}
	
	public void setActionListener (Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new StartStopButtonActionListener(window));
			actionListenerSet = true;
		}
	}

}