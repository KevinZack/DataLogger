package Componets.SetFactors;

import javax.swing.JButton;
import Gui.SetFactors;

public class CancelButton extends JButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -148808294457603732L;
	private boolean actionListenerSet = false;

	
	public CancelButton()
	{
		super("Cancel");	
		this.setName("Cancel");
	}
	
	public void setActionListener (SetFactors setFactors)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new CancelButtonActionListener(setFactors));
			actionListenerSet = true;
		}
	}

}