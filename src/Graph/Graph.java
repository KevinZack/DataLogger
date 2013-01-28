package Graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import Componets.Graph.GraphTimeRadial;
import Componets.Graph.CaptureButton;
import Data.Data;
import Events.PayloadUpdateGraphEventListener;
import Main.DataManager;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class Graph
{
	private JPanel contentPane;
	
	public ChartPanel CP;
	public JFreeChart chart;
	public JFreeChart jFreeChart;
	public String deviceName;
	
	public int time;
	public int seriesCount;
	public int seriesStart;
	
	public double y1;
	public double y2;
	public double y3;
	public double x;
	private JMenuBar menuBar;
	private JMenu mnData;
	private JMenu mnDatapoints;
	public GraphTimeRadial time15;
	public GraphTimeRadial time30;
	public GraphTimeRadial time60;
	public GraphTimeRadial time120;
	public GraphTimeRadial time300;
	public GraphTimeRadial time600;
	public GraphTimeRadial timeAll;
	public CaptureButton captureButton;
	public boolean pause = false;
	public int dataPointSet = 15;
	public int dataPointCount = 0;
	public int hasDeleted = 0;
	public ButtonGroup dataTime;
	public String title="";
	public String xAxisLable="";
	public String yAxisLable="";
	public int senOneIndexY1 = 0;
	public  int senTwoIndexY1 = 0;
	public int opperatorIndexY1 = 0;
	public int senOneIndexX = 0;
	public  int senTwoIndexX = 0;
	public int opperatorIndexX = 0;
	public int opperatorIndexY2;
	public int senOneIndexY2;
	public int senTwoIndexY2;
	public int opperatorIndexY3; 
	public int senOneIndexY3;
	public int senTwoIndexY3;
	public int seriesNumber=1;
	public int type = 0;
	public XYSeries series1;
	public  XYSeries series2;
	public  XYSeries series3;
	public XYSeries copySeries1;
	public  XYSeries copySeries2;
	public  XYSeries copySeries3;
	public XYSeriesCollection dataset;
	private PayloadUpdateGraphEventListener listener;
    private JFrame frame;
    public GraphData graphData;

	
	public Graph(String title, String xAxisLable, String yAxisLable, int senOneIndexY1, int senTwoIndexY1, 
			int opperatorIndexY1, int senOneIndexX, int senTwoIndexX, int opperatorIndexX, 
			int opperatorIndexY2, int senOneIndexY2, int senTwoIndexY2, int opperatorIndexY3, 
			int senOneIndexY3, int senTwoIndexY3, int seriesNumber,int type) 
	{
		this.title = title;
		this.xAxisLable = xAxisLable;
		this.yAxisLable = yAxisLable;
		this.senOneIndexY1 = senOneIndexY1;
		this.senTwoIndexY1 = senTwoIndexY1;
		this.opperatorIndexY1 = opperatorIndexY1;
		this.senOneIndexY2 = senOneIndexY2;
		this.senTwoIndexY2 = senTwoIndexY2;
		this.opperatorIndexY2 = opperatorIndexY2;
		this.senOneIndexY3 = senOneIndexY3;
		this.senTwoIndexY3 = senTwoIndexY3;
		this.opperatorIndexY3 = opperatorIndexY3;
		this.senOneIndexX = senOneIndexX;
		this.senTwoIndexX = senTwoIndexX;
		this.opperatorIndexX = opperatorIndexX;
		this.seriesNumber = seriesNumber;
		this.type = type;
		
		createGraph();
	}
	
	public void createGraph()
	{
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 584);
		frame.setLocation(600,30);
		frame.setVisible(true);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnData = new JMenu("Data");
		menuBar.add(mnData);
		mnDatapoints = new JMenu("DataPoints");

		dataTime = new ButtonGroup();
		
		time15 = new GraphTimeRadial(this,"15 Data Points");
		time15.setActionListener();
		time15.setSelected(true);
		dataTime.add(time15);
		

		time30 = new GraphTimeRadial(this,"30 Data Points");
		time30.setActionListener();
		dataTime.add(time30);
		
				
		time60 = new GraphTimeRadial(this,"60 Data Points");
		time60.setActionListener();
		dataTime.add(time60);
		
		
		time120 = new GraphTimeRadial(this,"120 Data Points");
		time120.setActionListener();
		dataTime.add(time120);
		
		
		time300 = new GraphTimeRadial(this,"300 Data Points");
		time300.setActionListener();
		dataTime.add(time300);
		
		
		time600 = new GraphTimeRadial(this,"600 Data Points");
		time600.setActionListener();
		dataTime.add(time600);
		mnDatapoints.add(time300);
		
		timeAll = new GraphTimeRadial(this,"All Data Points");
		timeAll.setActionListener();
		dataTime.add(timeAll);		
		
		mnDatapoints.add(time15);
		mnDatapoints.add(time30);
		mnDatapoints.add(time60);
		mnDatapoints.add(time120);
		mnDatapoints.add(time300);
		mnDatapoints.add(time300);
		mnDatapoints.add(timeAll);
		
		mnData.add(mnDatapoints);

	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("429px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "2, 2, 11, 1, fill, fill");
		
		dataset = new XYSeriesCollection();
		createSeries();


	
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

		if(type == 0)
		{
			chart = ChartFactory.createXYLineChart(title, xAxisLable, yAxisLable,dataset,
		                                           PlotOrientation.VERTICAL, false, true, false);
		}
		else if(type == 1)
		{
			chart = ChartFactory.createScatterPlot(title, xAxisLable, yAxisLable, dataset,
				PlotOrientation.VERTICAL, false, false, false);
		}
		
		
		
		chart.setBackgroundPaint(Color.white);
		panel.setLayout(new BorderLayout(0, 0));
		
		
         
		CP = new ChartPanel(chart);
		
		
		CP.setMaximumDrawWidth(1023);
		CP.setZoomAroundAnchor(true);
		CP.setHorizontalAxisTrace(true);
		CP.setMouseZoomable(false);
		CP.setRefreshBuffer(true);
		CP.setVerticalAxisTrace(true);
		
		panel.add(CP);
		
		captureButton = new CaptureButton();
		contentPane.add(captureButton, "2, 4");
		captureButton.setActionListener(this);
		
		panel.validate();
		
		frame.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				close();
				graphData.frame.setVisible(false);
			}
		});
		graphData = new GraphData(title, seriesNumber);
		
	}
	


	
	public void createSeries()
	{
		series1 = new XYSeries("Series 1");
		copySeries1 = new  XYSeries("Pause Series 1");
		
		dataset.addSeries(series1);
		
		if(seriesNumber>1)
		{
			series2 = new XYSeries("Series 2");
			copySeries2 = new  XYSeries("Pause Series 2");
			dataset.addSeries(series2);
		}
		if(seriesNumber >2)
		{
			series3 = new XYSeries("Series 3");
			copySeries3 = new  XYSeries("Pause Series 3");
			dataset.addSeries(series3);
		}
		
	}
	
	public void close()
	{
		DataManager.removePayloadUpdateEvent(listener);
	}
	
	public void capture()
	{
		try 
		{
			copySeries1 = series1.createCopy(0, series1.getItemCount()-1);
			if(seriesNumber>1)
			{
				copySeries2 = series2.createCopy(0, series2.getItemCount()-1);
			}
			if(seriesNumber>2)
			{
				copySeries3 = series3.createCopy(0, series3.getItemCount()-1);
			}
		} catch (CloneNotSupportedException e) {e.printStackTrace();}
		
		new CopyOfGraph(title, xAxisLable, yAxisLable, copySeries1, copySeries2, copySeries3, seriesNumber, type);
	}
	
	
	
	public void updateData(final Data data) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {

			    seriesCount = seriesCount + 1;
				y1 = sensorValueY(data,opperatorIndexY1,senOneIndexY1,senTwoIndexY1);
				x = sensorValueX(data);
					
				series1.add(x, y1);
	
					
				if(seriesNumber>1)
				{
					y2 = sensorValueY(data,opperatorIndexY2,senOneIndexY2,senTwoIndexY2);
					series2.add(x, y2);
				}
				if(seriesNumber >2)
				{
					y3 = sensorValueY(data,opperatorIndexY3,senOneIndexY3,senTwoIndexY3);
					series3.add(x, y3);
				}
					
				if(seriesCount-seriesStart > dataPointSet && dataPointSet > 0) // Do i need this or is it handled with action listener?
				{
					series1.remove(0);
					seriesStart++;
					
					if(seriesNumber>1)
					{
						series2.remove(0);
					}
					if(seriesNumber >2)
					{
						series3.remove(0);
					}
						
				}
				graphData.updateData(series1, series2, series3);
				
				CP.validate();
				
		    }
		  });
	}

	   
	public double sensorValueY(Data data, int OpperatorIndex, int sensorOneIndex, int sensorTwoIndex)
	{
		double sensorValue = 0;
		double firstData = getFirstDataY(data,sensorOneIndex);
		double secondData = getSecondDataY(data,sensorTwoIndex);
		
		if(OpperatorIndex == 0)
		{
			sensorValue = firstData;
		}
		if(OpperatorIndex == 1)
		{
			sensorValue = firstData + secondData;
		}
		if(OpperatorIndex == 2)
		{
			sensorValue = firstData - secondData;
		}
		if(OpperatorIndex == 3)
		{
			sensorValue = firstData * secondData;
		}
		if(OpperatorIndex == 4)
		{
			sensorValue = firstData / secondData;
		}
		
		return sensorValue;
	}
	public double getFirstDataY(Data data, int sensorOneIndex)
	{
		double sensorValue = 0;
		switch (sensorOneIndex)
		{
		case 0: sensorValue = (double)data.time;
				break;
		case 1: sensorValue =  (double)data.sensorOne;
				break;
		case 2: sensorValue =  (double)data.sensorTwo;
				break;
		case 3: sensorValue =  (double)data.sensorThree;
				break;
		case 4: sensorValue =  (double)data.sensorFour;
				break;
		case 5: sensorValue =  (double)data.sensorFive;
				break;
		case 6: sensorValue =  (double)data.sensorSix;
				break;
		}
		return sensorValue;
	}
	public double getSecondDataY(Data data, int sensorTwoIndex)
	{
		double sensorValue = 0;
		switch (sensorTwoIndex)
		{
		case 0: sensorValue = (double)data.time;
				break;
		case 1: sensorValue =  (double)data.sensorOne;
				break;
		case 2: sensorValue =  (double)data.sensorTwo;
				break;
		case 3: sensorValue =  (double)data.sensorThree;
				break;
		case 4: sensorValue =  (double)data.sensorFour;
				break;
		case 5: sensorValue =  (double)data.sensorFive;
				break;
		case 6: sensorValue =  (double)data.sensorSix;
				break;
		}
		return sensorValue;
	}
	
	public double sensorValueX(Data data)
	{
		double sensorValue = 0;
		double firstData = getFirstDataX(data);
		double secondData = getSecondDataX(data);
		if(opperatorIndexX == 0)
		{
			sensorValue = firstData;
		}
		if(opperatorIndexX == 1)
		{
			sensorValue = firstData + secondData;
		}
		if(opperatorIndexX == 2)
		{
			sensorValue = firstData - secondData;
		}
		if(opperatorIndexX == 3)
		{
			sensorValue = firstData * secondData;
		}
		if(opperatorIndexX == 4)
		{
			sensorValue = firstData / secondData;
		}
		
		return sensorValue;
	}
	
	public double getFirstDataX(Data data)
	{
		double sensorValue = 0;
		switch (senOneIndexX)
		{
		case 0: sensorValue = (double)data.time;
				break;
		case 1: sensorValue =  (double)data.sensorOne;
				break;
		case 2: sensorValue =  (double)data.sensorTwo;
				break;
		case 3: sensorValue =  (double)data.sensorThree;
				break;
		case 4: sensorValue =  (double)data.sensorFour;
				break;
		case 5: sensorValue =  (double)data.sensorFive;
				break;
		case 6: sensorValue =  (double)data.sensorSix;
				break;
		}
		return sensorValue;
	}
	public double getSecondDataX(Data data)
	{
		double sensorValue = 0;
		switch (senTwoIndexX)
		{
		case 0: sensorValue = (double)data.time;
				break;
		case 1: sensorValue =  (double)data.sensorOne;
				break;
		case 2: sensorValue =  (double)data.sensorTwo;
				break;
		case 3: sensorValue =  (double)data.sensorThree;
				break;
		case 4: sensorValue =  (double)data.sensorFour;
				break;
		case 5: sensorValue =  (double)data.sensorFive;
				break;
		case 6: sensorValue =  (double)data.sensorSix;
				break;
		}
		return sensorValue;
	}
	
	
	public void getListener(PayloadUpdateGraphEventListener listener)
	{
		this.listener = listener;
		
	}
}
