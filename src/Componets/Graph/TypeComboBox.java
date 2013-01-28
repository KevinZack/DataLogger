package Componets.Graph;

import javax.swing.JComboBox;

import Gui.CreateGraph;


public class TypeComboBox extends JComboBox<String>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean actionListenerSet = false;
	public String graphName;
	public int sensorNubmer;
	
	public TypeComboBox()
	{
		super();
	}	
	
	public void setActionListener(CreateGraph createGraph)
	{
		if(!actionListenerSet)
		{
			this.addItemListener( new TypeComboBoxActionListener(this,createGraph));
			actionListenerSet = true;
		}
	}

}