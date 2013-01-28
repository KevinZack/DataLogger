package Componets.Graph;

import javax.swing.JComboBox;

import Gui.CreateGraph;


public class OpperatorComboBox extends JComboBox<String>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean actionListenerSet = false;
	public String graphName;
	public int sensorNubmer;
	
	public OpperatorComboBox()
	{
		super();
	}	
	
	public void setActionListener(CreateGraph createGraph,JComboBox<String> comboSenNum)
	{
		if(!actionListenerSet)
		{
			this.addItemListener( new OpperatorComboBoxActionListener(this,createGraph,comboSenNum));
			actionListenerSet = true;
		}
	}

}