package Componets.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Events.PayloadUpdateGraphEventListener;
import Graph.Graph;
import Gui.CreateGraph;
import Main.DataManager;

public class CreateButtonActionListener  implements ActionListener
{
	private CreateGraph createGraph;
	
	public CreateButtonActionListener(CreateGraph createGraph)
	{
		this.createGraph = createGraph;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		int opperatorIndexY1 = createGraph.opperatorComboBoxY1.getSelectedIndex();
		int senOneIndexY1 = createGraph.comboSenOneY1.getSelectedIndex();
		int senTwoIndexY1 = createGraph.comboSenTwoY1.getSelectedIndex();
		int opperatorIndexX = createGraph.opperatorComboBoxX.getSelectedIndex();
		int senOneIndexX =createGraph.comboSenOneX.getSelectedIndex();
		int senTwoIndexX = createGraph.comboSenTwoX.getSelectedIndex();
		int opperatorIndexY2 = createGraph.opperatorComboBoxY2.getSelectedIndex();
		int senOneIndexY2 =  createGraph.comboSenOneY2.getSelectedIndex();
		int senTwoIndexY2 =  createGraph.comboSenTwoY2.getSelectedIndex();
		int opperatorIndexY3 = createGraph.opperatorComboBoxY3.getSelectedIndex();
		int senOneIndexY3 =  createGraph.comboSenOneY3.getSelectedIndex();
		int senTwoIndexY3 =  createGraph.comboSenTwoY3.getSelectedIndex();
		
		String tempString;
		String tempNameY = null;
		String tempNameX = null;
		
		if(createGraph.seriesNumber == 1)
		{	
			if(opperatorIndexY1 == 0)
			{
				tempNameY = createGraph.comboSenOneY1.getSelectedItem().toString();
			}
			if(opperatorIndexY1 == 1)
			{
				tempNameY = createGraph.comboSenOneY1.getSelectedItem() + "+" +
						    createGraph.comboSenTwoY1.getSelectedItem().toString();
			}
			if(opperatorIndexY1 == 2)
			{
				tempNameY = createGraph.comboSenOneY1.getSelectedItem() + "-" +
						    createGraph.comboSenTwoY1.getSelectedItem().toString();
			}
			if(opperatorIndexY1 == 3)
			{
				tempNameY = createGraph.comboSenOneY1.getSelectedItem() + "*" +
						    createGraph.comboSenTwoY1.getSelectedItem().toString();
			}
			if(opperatorIndexY1 == 4)
			{
				tempNameY = createGraph.comboSenOneY1.getSelectedItem() + "/" +
						    createGraph.comboSenTwoY1.getSelectedItem().toString();
			}
		
		}
		else
		{
			tempNameY = "Various";
		}
		
		if(opperatorIndexX== 0)
		{
			tempNameX = createGraph.comboSenOneX.getSelectedItem().toString();
		}
		if(opperatorIndexX == 1)
		{
			tempNameX = createGraph.comboSenOneX.getSelectedItem() + "+" +
						createGraph.comboSenTwoX.getSelectedItem().toString();
		}
		if(opperatorIndexX == 2)
		{
			tempNameX = createGraph.comboSenOneX.getSelectedItem() + "-" +
						createGraph.comboSenTwoX.getSelectedItem().toString();
		}
		if(opperatorIndexX == 3)
		{
			tempNameX = createGraph.comboSenOneX.getSelectedItem() + "*" +
						createGraph.comboSenTwoY1.getSelectedItem().toString();
		}
		if(opperatorIndexX == 4)
		{
			tempNameX = createGraph.comboSenOneX.getSelectedItem() + "/" +
					    createGraph.comboSenTwoY1.getSelectedItem().toString();
		}
		
		int type = createGraph.typeComboBox.getSelectedIndex();
		
		
		tempString = tempNameX +" vs " + tempNameY;
		Graph graph = new Graph(tempString, tempNameX, tempNameY, senOneIndexY1, senTwoIndexY1, opperatorIndexY1,
				                            senOneIndexX, senTwoIndexX, opperatorIndexX,opperatorIndexY2,senOneIndexY2,
				                            senTwoIndexY2,opperatorIndexY3,senOneIndexY3,senTwoIndexY3,createGraph.seriesNumber ,type);
		
		
		PayloadUpdateGraphEventListener listener = new PayloadUpdateGraphEventListener(graph);
		DataManager.addPayloadUpdateEvent(listener);
		graph.getListener(listener);
		
		createGraph.setVisible(false);
    } 		 

}