package Componets.Graph;

import javax.swing.JButton;
import Graph.Graph;

public class CaptureButton extends JButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2058184282223465597L;
	private boolean actionListenerSet = false;
	
	public CaptureButton()
	{
		super("Capture");
	}
	
	public void setActionListener (Graph graph)
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new CaptureButtonActionListener(this,graph));
			actionListenerSet = true;
		}
	}
}
