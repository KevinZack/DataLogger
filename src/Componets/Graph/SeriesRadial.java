package Componets.Graph;

import javax.swing.JRadioButtonMenuItem;
import Graph.CopyOfGraph;

public class SeriesRadial extends JRadioButtonMenuItem  
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CopyOfGraph graph;
	boolean actionListenerSet = false;
	public int seriesNumber;
	public SeriesRadial(CopyOfGraph graph, int seriesNumber)
	{
		super();
		this.seriesNumber = seriesNumber;
		String temp = "Series" + seriesNumber;
		this.setText(temp);	
		this.graph = graph;
	}	
	
	public void setActionListener()
	{
		if(!actionListenerSet)
		{
			this.addActionListener( new SeriesRadialActionListener(graph,this));
			actionListenerSet = true;
		}
	}
	

}
