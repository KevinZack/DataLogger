package Componets.MenueItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Parsers.Parsing;

public class ResetAveMenuItemActionListener implements ActionListener
{
	public Parsing parsing;
	
	public ResetAveMenuItemActionListener(Parsing parsing)
	{
		this.parsing = parsing;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		parsing.totalEntries = 0;
		parsing.totalSensorOne = 0;
		parsing.totalSensorTwo = 0;
		parsing.totalSensorThree = 0;
		parsing.totalSensorFour = 0;
		parsing.totalSensorFive = 0;
		parsing.totalSensorSix = 0;
    } 		 

}
