package Componets.MenueItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.CreateGraph;

public class SeriesNumberMenuItemActionListener implements ActionListener
{
	public int number;
	public CreateGraph createGraph;
	
	public SeriesNumberMenuItemActionListener(CreateGraph createGraph,int number)
	{
		this.number = number;
		this.createGraph = createGraph;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		createGraph.changeNumberOfSeries(number);
		
    } 		 

}
