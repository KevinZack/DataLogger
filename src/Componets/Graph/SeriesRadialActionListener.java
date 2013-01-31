package Componets.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Graph.CopyOfGraph;

public class SeriesRadialActionListener implements ActionListener
{
	public CopyOfGraph graph;
	public SeriesRadial seriesRadial;
	public SeriesRadialActionListener(CopyOfGraph graph, SeriesRadial seriesRadial)
	{
		this.graph = graph;
		this.seriesRadial = seriesRadial;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
	//	graph.useSeries = seriesRadial.seriesNumber;
	}

}