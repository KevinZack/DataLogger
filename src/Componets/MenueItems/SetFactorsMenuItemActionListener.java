package Componets.MenueItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.SetFactors;
import Gui.Window;
import Parsers.Parsing;

public class SetFactorsMenuItemActionListener implements  ActionListener
{

	public Parsing parsing;
	public Window window;
	
	public SetFactorsMenuItemActionListener(Parsing parsing, Window window)
	{
		this.parsing = parsing;
		this.window = window;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		new SetFactors(parsing,window);
	}
	

}
