package Componets.MenueItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.Window;

public class DecimalPlacesMenuItemActionListener implements ActionListener
{
	public int places;
	public Window window;
	public DecimalPlacesMenuItemActionListener(int places, Window window)
	{
		this.places = places;
		this.window = window;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		window.setDecimalPlaces(places);
    } 		 

}
