package Componets.SetFactors;

import javax.swing.JButton;
import Gui.SetFactors;
import Parsers.Parsing;

public class SaveButton extends JButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6721102436356179320L;
	private boolean actionListenerSet = false;

	
	public SaveButton()
	{
		super("Save");	
		this.setName("Save");
	}
	
	public void setActionListener (Parsing parsing, SetFactors setFactors)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new SaveButtonActionListener(parsing, setFactors));
			actionListenerSet = true;
		}
	}

}