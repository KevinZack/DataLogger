package Componets.Graph;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import Graph.CopyOfGraph;

public class GraphChartPanel extends ChartPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1146318384315666917L;
	private boolean actionListenerSet = false;
	
	public GraphChartPanel(JFreeChart chart) 
	{
		super(chart);
		
	}

	
	public void setActionListener (CopyOfGraph createGraph, XYSeries series1)
	{
		if(!actionListenerSet)
		{
			this.addChartMouseListener( new GraphChartPannelActionListener(this, createGraph, series1));
			actionListenerSet = true;
		}
	}
}
