package Componets.Resets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.Window;

public class StartStopButtonActionListener implements ActionListener
{
	public Window window;
	public boolean start = true;
	public StartStopButtonActionListener(Window window)
	{
		this.window = window;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		if(start)
		{
			window.takeData = false;
			window.startStopButton.setText("Stopped");
			start = false;
		}
		else
		{
			window.takeData = true;
			window.startStopButton.setText("Started");
			start = true;
		}
    } 		 

}