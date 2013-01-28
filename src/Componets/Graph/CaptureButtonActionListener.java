package Componets.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Graph;

public class CaptureButtonActionListener  implements ActionListener
{
	public Graph graph;
	public CaptureButton pauseButton;
	public CaptureButtonActionListener(CaptureButton pauseButton, Graph graph)
	{
		this.graph = graph;
		this.pauseButton = pauseButton;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
			graph.capture();
	}
}
