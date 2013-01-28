package Graph;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import Componets.Graph.GraphChartPanel;
import Componets.Graph.SeriesRadial;
import Events.PayloadUpdateGraphEventListener;
import Main.DataManager;
import javax.swing.ButtonGroup;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import org.jfree.chart.plot.ValueMarker;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class CopyOfGraph
{
	private JPanel contentPane;
	public GraphChartPanel CP;
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
	private XYSeriesCollection dataset;
	private PayloadUpdateGraphEventListener listener;
    private JFrame frame;
    public GraphData graphData;
	public ValueMarker firstMark;
	public int firstMarkSeriesIndex;
	public ValueMarker secondMark;
	public int secondeMarkSeriesIndex;
	public boolean priMarkSet = false;
	public boolean secMarkSet = false;
	public XYTextAnnotation textAnnotaion;
    public XYPlot chartPlot;
    private JMenuBar menuBar;
    private JMenu mnSeries;
	public ButtonGroup buttonGroup;
	public SeriesRadial seriesRadial1;
	public SeriesRadial seriesRadial2;
	public SeriesRadial seriesRadial3;
	public int useSeries = 1;
	public DecimalFormat df;
	public CopyOfGraph(String title, String xAxisLable, String yAxisLable, XYSeries series1, XYSeries series2, XYSeries series3, int seriesNumber,int type) 
	{
		this.title = title;
		this.xAxisLable = xAxisLable;
		this.yAxisLable = yAxisLable;
		this.series1 = series1;
		this.series2 = series2;
		this.series3 = series3;
		this.seriesNumber = seriesNumber;
		this.type = type;
		df = new DecimalFormat("#.####");
		createGraph();
	}

	public void addMarker(double currentX, int seriesIndex, Rectangle2D plotRectangle)
	{	
		BasicStroke bs = new BasicStroke(1);
		chartPlot = chart.getXYPlot();
		Color color;

		
		
		if(useSeries == 1)
		{
			color = Color.RED;
		}
		else if(useSeries == 2)
		{
			color = Color.BLUE;
		}
		else
		{
			color = Color.GREEN;
		}
		
		if(!priMarkSet && !secMarkSet)
		{	
			firstMark = new ValueMarker(currentX, color, bs);
			chartPlot.addDomainMarker(firstMark);
			firstMarkSeriesIndex = seriesIndex;
			priMarkSet = true;
		}
		else if (priMarkSet && !secMarkSet)
		{
			secondMark = new ValueMarker(currentX, color, bs);
			secMarkSet = true;
			chartPlot.addDomainMarker(secondMark);

			secondeMarkSeriesIndex = seriesIndex;
			
			String Temp = df.format(integration(firstMarkSeriesIndex,secondeMarkSeriesIndex));

			textAnnotaion = new XYTextAnnotation(Temp, chartPlot.getDomainCrosshairValue(),chartPlot.getRangeCrosshairValue());
			textAnnotaion.setFont(new Font("Tahoma", Font.BOLD, 20));
			chartPlot.addAnnotation(textAnnotaion);
		}
		else
		{
			priMarkSet = false;
			secMarkSet = false;

			chartPlot.removeDomainMarker(firstMark);
			chartPlot.removeDomainMarker(secondMark);
			chartPlot.removeAnnotation(textAnnotaion);
		}
	}

	public double integration(int firstMarkSeriesIndex, int secondeMarkSeriesIndex)
	{
		double totalIntgration = 0;
		if(useSeries == 1)
		{
			if(firstMarkSeriesIndex < secondeMarkSeriesIndex)
			{
				for(int i = firstMarkSeriesIndex; i < secondeMarkSeriesIndex; i++)
				{
					double tempX = series1.getX(i+1).doubleValue() - series1.getX(i).doubleValue();
					double tempY = series1.getY(i+1).doubleValue() + series1.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
				}
			}
			else
			{
				for(int i = secondeMarkSeriesIndex; i < firstMarkSeriesIndex; i++)
				{
					double tempX = series1.getX(i+1).doubleValue() - series1.getX(i).doubleValue();
					double tempY = series1.getY(i+1).doubleValue() + series1.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
				}
				totalIntgration = -1*totalIntgration;
			}
		}
		else if(useSeries == 2)
		{
			if(firstMarkSeriesIndex < secondeMarkSeriesIndex)
			{
				for(int i = firstMarkSeriesIndex; i <= secondeMarkSeriesIndex; i++)
				{
					double tempX = series2.getX(i+1).doubleValue() - series2.getX(i).doubleValue();
					double tempY = series2.getY(i+1).doubleValue() + series2.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
				}
			}
			else
			{
				for(int i = secondeMarkSeriesIndex; i <= firstMarkSeriesIndex; i++)
				{
					double tempX = series2.getX(i+1).doubleValue() - series2.getX(i).doubleValue();
					double tempY = series2.getY(i+1).doubleValue() + series2.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
					
				}
				totalIntgration = -1*totalIntgration;
			}
		}
		else
		{
			if(firstMarkSeriesIndex < secondeMarkSeriesIndex)
			{
				for(int i = firstMarkSeriesIndex; i <= secondeMarkSeriesIndex; i++)
				{
					double tempX = series3.getX(i+1).doubleValue() - series3.getX(i).doubleValue();
					double tempY = series3.getY(i+1).doubleValue() + series3.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
				}
			}
			else
			{
				for(int i = secondeMarkSeriesIndex; i <= firstMarkSeriesIndex; i++)
				{
					double tempX = series3.getX(i+1).doubleValue() - series3.getX(i).doubleValue();
					double tempY = series3.getY(i+1).doubleValue() + series3.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
					
				}
				totalIntgration = -1*totalIntgration;
			}
		}
		totalIntgration = 0.5*totalIntgration;
	
		return totalIntgration;
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
		
		mnSeries = new JMenu("Series");
		menuBar.add(mnSeries);
		
		buttonGroup = new ButtonGroup();
		
		seriesRadial1 = new SeriesRadial(this,1);
		buttonGroup.add(seriesRadial1);
		mnSeries.add(seriesRadial1);
		seriesRadial1.setActionListener();
		
		if(seriesNumber >1)
		{

			seriesRadial2 = new SeriesRadial(this,2);
			buttonGroup.add(seriesRadial2);
			mnSeries.add(seriesRadial2);
			seriesRadial2.setActionListener();
		}
		if(seriesNumber > 2)
		{
			seriesRadial3 = new SeriesRadial(this,3);
			buttonGroup.add(seriesRadial3);
			mnSeries.add(seriesRadial3);
			seriesRadial3.setActionListener();
		}

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
		
		dataset.addSeries(series1);

		if(seriesNumber > 1)
		{
			dataset.addSeries(series2);
		}
		if(seriesNumber > 2)
		{
			dataset.addSeries(series3);
		}
	
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

		if(type == 0)
		{
			chart = ChartFactory.createXYLineChart(title, xAxisLable, yAxisLable,dataset,
		                                           PlotOrientation.VERTICAL, true, true, false);
		}
		else if(type == 1)
		{
			chart = ChartFactory.createScatterPlot(title, xAxisLable, yAxisLable, dataset,
				PlotOrientation.VERTICAL, true, true, false);
		}
		
		
		
		chart.setBackgroundPaint(Color.white);
		panel.setLayout(new BorderLayout(0, 0));
		
		
         
		CP = new GraphChartPanel(chart);
		
		CP.setMaximumDrawWidth(1023);
		CP.setZoomAroundAnchor(true);
		CP.setHorizontalAxisTrace(false);
		CP.setMouseZoomable(false);
		CP.setRefreshBuffer(true);
		CP.setVerticalAxisTrace(false);
		
		panel.add(CP);
		CP.getChart().getXYPlot().setDomainCrosshairLockedOnData(true);
		CP.getChart().getXYPlot().setDomainCrosshairVisible(true);
		CP.getChart().getXYPlot().setRangeCrosshairVisible(true);
		CP.getChart().getXYPlot().setRangeCrosshairLockedOnData(true); 
		
		CP.setActionListener(this,series1);

		panel.validate();
		
		frame.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				close();
			}
		});
		chartPlot = chart.getXYPlot();
		frame.pack();
	}
	


	
	public void close()
	{
		DataManager.removePayloadUpdateEvent(listener);
	}

}
