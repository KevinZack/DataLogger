package Componets.SetFactors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.SetFactors;
import Parsers.Parsing;

public class SaveButtonActionListener implements ActionListener
{
	public Parsing parsing;
	public SetFactors setFactors;
	public double timeFactor = 1;
	public double senOneFactor = 1;
	public double senTwoFactor = 1;
	public double senThreeFactor = 1;
	public double senFourFactor = 1;
	public double senFiveFactor = 1;
	public double senSixFactor = 1;
	public int size = 0;
	
	public SaveButtonActionListener(Parsing parsing, SetFactors setFactors)
	{
		this.parsing = parsing;
		this.setFactors = setFactors;
		this.size = parsing.size;
		
	}

	public void actionPerformed(ActionEvent arg0) 
	{		
		
		if(!setFactors.changeTime.getText().isEmpty())	
		{
			timeFactor = Double.parseDouble(setFactors.changeTime.getText());
		}
		else
		{
			timeFactor = setFactors.timeFactor;
		}
		if(!setFactors.changeSenOne.getText().isEmpty())	
		{
			senOneFactor = Double.parseDouble(setFactors.changeSenOne.getText());
		}
		else
		{
			senOneFactor = setFactors.sensorOneFactor;
		}
		if(size > 1 && !setFactors.changeSenTwo.getText().isEmpty())
		{
			senTwoFactor = Double.parseDouble(setFactors.changeSenTwo.getText());
		}
		else
		{
			senTwoFactor = setFactors.sensorTwoFactor;
		}
		if(size > 2 && !setFactors.changeSenThree.getText().isEmpty())
		{
			senThreeFactor = Double.parseDouble(setFactors.changeSenThree.getText());
		}
		else
		{
			senThreeFactor = setFactors.sensorThreeFactor;
		}
		if(size > 3 && !setFactors.changeSenFour.getText().isEmpty())
		{
			senFourFactor = Double.parseDouble(setFactors.changeSenFour.getText());
		}
		else
		{
			senFourFactor = setFactors.sensorFourFactor;
		}
		if(size > 3 && !setFactors.changeSenFive.getText().isEmpty())
		{
			senFiveFactor = Double.parseDouble(setFactors.changeSenFive.getText());
		}
		else
		{
			senFiveFactor = setFactors.sensorFiveFactor;
		}
		if(size > 4 && !setFactors.changeSenSix.getText().isEmpty())
		{
			senSixFactor = Double.parseDouble(setFactors.changeSenSix.getText());
		}
		else
		{
			senSixFactor = setFactors.sensorSixFactor;
		}
		

		parsing.changeFactors(timeFactor, senOneFactor, senTwoFactor, senThreeFactor, senFourFactor, senFiveFactor, senSixFactor);
		setFactors.setVisible(false);
    } 		 

}
