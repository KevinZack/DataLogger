package Componets.Graph;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import Gui.CreateGraph;


public class OpperatorComboBoxActionListener implements ItemListener 
{
	public CreateGraph createGraph;
	public OpperatorComboBox opperatorComboBox;
	public JComboBox<String> comboSenNum;
	
	public OpperatorComboBoxActionListener(OpperatorComboBox opperatorComboBox, CreateGraph createGraph, JComboBox<String> comboSenNum)
	{
		this.createGraph = createGraph;
		this.opperatorComboBox = opperatorComboBox;
		this.comboSenNum = comboSenNum;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(opperatorComboBox.getSelectedIndex() != 0)
		{
			comboSenNum.setEnabled(true);
		}
		else
		{
			comboSenNum.setEnabled(false);
		}
	
	}

}
