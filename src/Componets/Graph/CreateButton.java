package Componets.Graph;

import javax.swing.JButton;

import Gui.CreateGraph;


public class CreateButton extends JButton
{

	private static final long serialVersionUID = 2058184282223465597L;
	private boolean actionListenerSet = false;
	
	public CreateButton()
	{
		super("Create");
	}
	
	public void setActionListener (CreateGraph createGraph)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new CreateButtonActionListener(createGraph));
			actionListenerSet = true;
		}
	}
}
