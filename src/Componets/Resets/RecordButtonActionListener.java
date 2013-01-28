package Componets.Resets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.Window;

public class RecordButtonActionListener implements ActionListener
{
	public Window window;
	public RecordButton recordButton;
	public boolean recordOn = true;
	
	public RecordButtonActionListener(RecordButton recordButton, Window window)
	{
		this.window = window;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		if(recordOn)
		{
			window.recordButton.setText("Recording");	
			window.record(true);
			recordOn = false;
		}
		else
		{
			window.recordButton.setText("Not Recording");	
			window.record(false);
			recordOn = true;
		}
		
    } 		 

}
