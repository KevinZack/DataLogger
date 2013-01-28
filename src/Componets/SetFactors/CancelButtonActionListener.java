package Componets.SetFactors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.SetFactors;

public class CancelButtonActionListener implements ActionListener
{
	public SetFactors setFactors;
	
	public CancelButtonActionListener(SetFactors setFactors) 
	{
		this.setFactors = setFactors;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		setFactors.setVisible(false);
    } 		 

}
