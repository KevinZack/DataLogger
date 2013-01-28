package Componets.MenueItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.Window;
import Parsers.Parsing;

public class ShowErrorsMenuItemActionListener implements  ActionListener
{

	public Parsing parsing;
	public Window window;
	
	public ShowErrorsMenuItemActionListener(Parsing parsing, Window window)
	{
		this.parsing = parsing;
		this.window = window;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		parsing.setErrors();
	}
	

}
