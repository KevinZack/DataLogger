package Componets.Graph;

import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import Graph.CopyOfGraph;

public class GraphChartPannelActionListener implements ChartMouseListener
{
	public GraphChartPanel graphChartPanel;
	public CopyOfGraph createGraph;
	public XYSeries series1;
	public double currentX = 0;
	public double currentY = 0;
	public int seriesIndex =0;
	public Rectangle2D plotRectangle;
	
	public GraphChartPannelActionListener(GraphChartPanel graphChartPanel, CopyOfGraph createGraph, XYSeries series1)
	{
		this.graphChartPanel = graphChartPanel;
		this.createGraph = createGraph;
		this.series1 = series1;
	}

	public void chartMouseClicked(ChartMouseEvent e) 
	{
		
		createGraph.addMarker(currentX, seriesIndex, plotRectangle);
    }

    public void chartMouseMoved(ChartMouseEvent arg0) 
    {
    	final XYPlot plot = graphChartPanel.getChart().getXYPlot();
        final ValueAxis domainAxis = plot.getDomainAxis();

        plotRectangle =  graphChartPanel.getChartRenderingInfo().getPlotInfo().getDataArea().getBounds();
        
        double mousetPosition = arg0.getTrigger().getX() - (series1.getX(4).doubleValue() - series1.getX(3).doubleValue());
        
        final double chartX = domainAxis.java2DToValue(mousetPosition , plotRectangle, plot.getDomainAxisEdge());
         	  	  
        double  bestDistanceFoundYetX = series1.getMaxX();
        int seriesXIndex = 0;
        
        bestDistanceFoundYetX = bestDistanceFoundYetX*bestDistanceFoundYetX;
        
        for(int i = 0; i < series1.getItemCount()  ; i++)
        {
        	double d = Math.abs(chartX - series1.getX(i).doubleValue());
         	d= d*d;
         	if (d <= bestDistanceFoundYetX) 
			{
         		bestDistanceFoundYetX = series1.getX(i).doubleValue();
				seriesXIndex = i;
			}
         }

         currentX = series1.getX(seriesXIndex).doubleValue();
         currentY = series1.getY(seriesXIndex).doubleValue();
         
         seriesIndex = seriesXIndex;

         
         graphChartPanel.getChart().getXYPlot().setDomainCrosshairValue(currentX);
         graphChartPanel.getChart().getXYPlot().setRangeCrosshairValue(currentY);  
         
    }
}
