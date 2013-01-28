package Componets.Graph;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Gui.CreateGraph;


public class TypeComboBoxActionListener implements ItemListener 
{
	public CreateGraph createGraph;
	public TypeComboBox typeComboBox;
	
	public TypeComboBoxActionListener(TypeComboBox typeComboBox,CreateGraph createGraph)
	{
		this.typeComboBox = typeComboBox;
		this.createGraph = createGraph;
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(typeComboBox.getSelectedIndex() == 2)
		{
			System.out.println("doSomething");
		}
		

	
	}

}
