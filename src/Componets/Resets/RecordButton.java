package Componets.Resets;

import javax.swing.JToggleButton;
import Gui.Window;

public class RecordButton extends JToggleButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2058184282223465597L;
	private boolean actionListenerSet = false;
	
	public RecordButton()
	{
		super();
	}
	
	public void setActionListener (Window window)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new RecordButtonActionListener(this,window));
			actionListenerSet = true;
		}
	}
}
