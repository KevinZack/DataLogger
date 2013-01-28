package Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphActionListener implements ActionListener
{
	public Graph timeGraph;
	
	public GraphActionListener(Graph timeGraph)
	{
		this.timeGraph = timeGraph;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(timeGraph.time15.isSelected())
		{
			timeGraph.dataPointSet = 15;
			int end = timeGraph.seriesCount-timeGraph.seriesStart-15;
			for(int i = 0; i < end; i++)
			{
				timeGraph.series1.remove(0);
				timeGraph.seriesStart++;
				
				if(timeGraph.seriesNumber>1)
				{
					timeGraph.series2.remove(0);
				}
				if(timeGraph.seriesNumber >2)
				{
					timeGraph.series3.remove(0);
				}
			}
		}
		
		if(timeGraph.time30.isSelected())
		{
			timeGraph.dataPointSet = 30;
			int end = timeGraph.seriesCount-timeGraph.seriesStart-30;
			for(int i = 0; i < end; i++)
			{
				timeGraph.series1.remove(0);
				timeGraph.seriesStart++;
				if(timeGraph.seriesNumber>1)
				{
					timeGraph.series2.remove(0);
				}
				if(timeGraph.seriesNumber >2)
				{
					timeGraph.series3.remove(0);
				}
			}
		}
		
		if(timeGraph.time60.isSelected())
		{
			timeGraph.dataPointSet = 60;
			int end = timeGraph.seriesCount-timeGraph.seriesStart-60;
			for(int i = 0; i < end; i++)
			{
				timeGraph.series1.remove(0);
				timeGraph.seriesStart++;
				if(timeGraph.seriesNumber>1)
				{
					timeGraph.series2.remove(0);
				}
				if(timeGraph.seriesNumber >2)
				{
					timeGraph.series3.remove(0);
				}
			}
		}
		
		if(timeGraph.time120.isSelected())
		{
			timeGraph.dataPointSet = 120;
			int end = timeGraph.seriesCount-timeGraph.seriesStart-120;
			for(int i = 0; i < end; i++)
			{
				timeGraph.series1.remove(0);
				timeGraph.seriesStart++;
				if(timeGraph.seriesNumber>1)
				{
					timeGraph.series2.remove(0);
				}
				if(timeGraph.seriesNumber >2)
				{
					timeGraph.series3.remove(0);
				}
			}
		}
		
		if(timeGraph.time300.isSelected())
		{
			timeGraph.dataPointSet = 300;
			int end = timeGraph.seriesCount-timeGraph.seriesStart-300;
			for(int i = 0; i < end; i++)
			{
				timeGraph.series1.remove(0);
				timeGraph.seriesStart++;
				if(timeGraph.seriesNumber>1)
				{
					timeGraph.series2.remove(0);
				}
				if(timeGraph.seriesNumber >2)
				{
					timeGraph.series3.remove(0);
				}
			}
		}
		
		if(timeGraph.time600.isSelected())
		{
			timeGraph.dataPointSet = 600;
			int end = timeGraph.seriesCount-timeGraph.seriesStart-60;
			for(int i = 0; i < end; i++)
			{
				timeGraph.series1.remove(0);
				timeGraph.seriesStart++;
				if(timeGraph.seriesNumber>1)
				{
					timeGraph.series2.remove(0);
				}
				if(timeGraph.seriesNumber >2)
				{
					timeGraph.series3.remove(0);
				}
			}
		}
		if(timeGraph.timeAll.isSelected())
		{
			timeGraph.dataPointSet = -1;
		}
		
		
    } 		 


}
