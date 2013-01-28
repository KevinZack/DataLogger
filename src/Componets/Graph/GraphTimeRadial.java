package Componets.Graph;

import javax.swing.JRadioButtonMenuItem;

import Graph.Graph;
import Graph.GraphActionListener;

public class GraphTimeRadial extends JRadioButtonMenuItem 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4757404618347565907L;
	
	public Graph graph;
	boolean actionListenerSet = false;
	
	public GraphTimeRadial(Graph timeGraph, String time)
	{
		super(time);	
		this.setName(time);
		this.graph = timeGraph;
	}	
	
	public void setActionListener()
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new GraphActionListener(graph));
			actionListenerSet = true;
		}
	}

}
