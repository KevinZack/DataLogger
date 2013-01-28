package Componets.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.CreateGraph;
import Gui.Window;


public class GraphMenuItemActionListener implements ActionListener
{
	public Window window;
	
	public GraphMenuItemActionListener(Window window)
	{
		this.window = window;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		new CreateGraph(window);	
	}
}