package Componets.MenueItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.Window;

public class ResetMinMaxMenuItemActionListener implements ActionListener
{
	public Window window;
	public int size = 0;
	
	public ResetMinMaxMenuItemActionListener(Window window)
	{
		this.window = window;
		this.size = window.size;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		Double tempSenOne = Double.parseDouble(window.sensorOneAve.getText());
		window.sensorOneMinValue = tempSenOne;
		window.sensorOneMaxValue = tempSenOne;
		
		Double tempSenTwo;
		if(size > 1)
		{
			tempSenTwo = Double.parseDouble(window.sensorTwoAve.getText());
			window.sensorTwoMinValue = tempSenTwo;
			window.sensorTwoMaxValue = tempSenTwo;
		}
		Double tempSenThree;
		if(size > 2)
		{
			tempSenThree = Double.parseDouble(window.sensorThreeAve.getText());
			window.sensorThreeMinValue = tempSenThree;
			window.sensorThreeMaxValue = tempSenThree;
		}
		Double tempSenFour;
		if(size > 3)
		{
			tempSenFour = Double.parseDouble(window.sensorFourAve.getText());
			window.sensorFourMinValue = tempSenFour;
			window.sensorFourMaxValue = tempSenFour;
		}
		Double tempSenFive;
		if(size > 4)
		{
			tempSenFive = Double.parseDouble(window.sensorFiveAve.getText());
			window.sensorFiveMinValue = tempSenFive;
			window.sensorFiveMaxValue = tempSenFive;
		}
		Double tempSenSix;
		if(size > 5)
		{
			tempSenSix = Double.parseDouble(window.sensorSixAve.getText());
			window.sensorSixMinValue = tempSenSix;
			window.sensorSixMaxValue = tempSenSix;
		}
    } 		 

}
