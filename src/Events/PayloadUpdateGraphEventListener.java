package Events;

import Graph.Graph;



public class PayloadUpdateGraphEventListener implements IPayloadUpdateUpdateGraphEventListener
{
	public  Graph timeGraph;


	
	public PayloadUpdateGraphEventListener (Graph timeGraph)
	{
		this.timeGraph = timeGraph;
	}

	public void PayloadUpdateUpdateEventHandeler(PayloadUpdateGraphEvent event) 
	{
			timeGraph.updateData(event.data);
	}

}

	