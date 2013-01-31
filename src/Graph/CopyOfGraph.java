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
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	public int secondMarkSeriesIndex;
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
	public DecimalFormat df;
	private JLabel lblMinimumS1;
	private JLabel lblMaximumS1;
	private JLabel lblIntegrationS1;
	private JTextField minimumS1;
	private JTextField maximumS1;
	private JTextField integrationS1;
	private JLabel lblSeriesS1;
	private JLabel lblMinimumS2;
	private JLabel lblSeriesS2;
	private JLabel lblMaximumS2;
	private JLabel lblIntegrationS2;
	private JLabel lblSeriesS3;
	private JLabel lblMinimumS3;
	private JLabel lblMaximumS3;
	private JLabel lblIntegrationS3;
	private JTextField minimumS2;
	private JTextField maximumS2;
	private JTextField integrationS2;
	private JTextField minimumS3;
	private JTextField maximumS3;
	private JTextField integrationS3;
	
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

		if(!priMarkSet && !secMarkSet)
		{	
			firstMark = new ValueMarker(currentX, Color.BLACK, bs);
			chartPlot.addDomainMarker(firstMark);
			firstMarkSeriesIndex = seriesIndex;
			priMarkSet = true;
		}
		else if (priMarkSet && !secMarkSet)
		{
			secondMark = new ValueMarker(currentX, Color.BLACK, bs);
			secMarkSet = true;
			chartPlot.addDomainMarker(secondMark);

			secondMarkSeriesIndex = seriesIndex;
			
			String integS1 = df.format(integration(firstMarkSeriesIndex,secondMarkSeriesIndex,1));
			String minS1 = df.format(minimum(firstMarkSeriesIndex,secondMarkSeriesIndex,1));
			String maxS1 = df.format(maximum(firstMarkSeriesIndex,secondMarkSeriesIndex,1));
			
			minimumS1.setText(minS1);
			maximumS1.setText(maxS1);
			integrationS1.setText(integS1);
			
			if(seriesNumber > 1)
			{
				String integS2 = df.format(integration(firstMarkSeriesIndex,secondMarkSeriesIndex,2));
				String minS2 = df.format(minimum(firstMarkSeriesIndex,secondMarkSeriesIndex,2));
				String maxS2 = df.format(maximum(firstMarkSeriesIndex,secondMarkSeriesIndex,2));	
				
				minimumS2.setText(minS2);
				maximumS2.setText(maxS2);
				integrationS2.setText(integS2);
			}
			if(seriesNumber > 2)
			{
				String integS3 = df.format(integration(firstMarkSeriesIndex,secondMarkSeriesIndex,3));
				String minS3 = df.format(minimum(firstMarkSeriesIndex,secondMarkSeriesIndex,3));
				String maxS3 = df.format(maximum(firstMarkSeriesIndex,secondMarkSeriesIndex,3));	
				
				minimumS3.setText(minS3);
				maximumS3.setText(maxS3);
				integrationS3.setText(integS3);
			}
		}
		else
		{
			priMarkSet = false;
			secMarkSet = false;

			chartPlot.removeDomainMarker(firstMark);
			chartPlot.removeDomainMarker(secondMark);
		}
	}
	
	public double maximum(int firstMarkSeriesIndex, int secondMarkSeriesIndex, int useSeries)
	{
		double maximum = 0;
		
		if(useSeries == 1)
		{
			maximum = series1.getMinY();
			
			for(int i = firstMarkSeriesIndex; i <= secondMarkSeriesIndex; i++)
			{
				if(maximum < series1.getY(i).doubleValue())
				{
					maximum = series1.getY(i).doubleValue();
				}
			}
		}
		
		if(useSeries == 2)
		{
			maximum = series2.getMinY();
			
			for(int i = firstMarkSeriesIndex; i <= secondMarkSeriesIndex; i++)
			{
				if(maximum < series2.getY(i).doubleValue())
				{
					maximum = series2.getY(i).doubleValue();
				}
			}
		}
		
		if(useSeries == 3)
		{
			maximum = series3.getMinY();
			
			for(int i = firstMarkSeriesIndex; i <= secondMarkSeriesIndex; i++)
			{
				if(maximum < series3.getY(i).doubleValue())
				{
					maximum = series3.getY(i).doubleValue();
				}
			}
		}
		
		return maximum;
	}
	
	public double minimum(int firstMarkSeriesIndex, int secondeMarkSeriesIndex, int useSeries)
	{
		double minimum = 0;
		
		if(useSeries == 1)
		{
			minimum = series1.getMaxY();
			
			for(int i = firstMarkSeriesIndex; i <= secondMarkSeriesIndex; i++)
			{
				if(minimum > series1.getY(i).doubleValue())
				{
					minimum = series1.getY(i).doubleValue();
				}
			}
		}
		
		else if(useSeries == 2)
		{
			minimum = series2.getMaxY();
			
			for(int i = firstMarkSeriesIndex; i <= secondMarkSeriesIndex; i++)
			{
				if(minimum > series2.getY(i).doubleValue())
				{
					minimum = series2.getY(i).doubleValue();
				}
			}
		}
		else if(useSeries == 3)
		{
			minimum = series3.getMaxY();
			
			for(int i = firstMarkSeriesIndex; i <= secondMarkSeriesIndex; i++)
			{
				if(minimum > series3.getY(i).doubleValue())
				{
					minimum = series3.getY(i).doubleValue();
				}
			}
		}
		
		return minimum;
	}

	public double integration(int firstMarkSeriesIndex, int secondeMarkSeriesIndex, int useSeries)
	{
		double totalIntgration = 0;
		if(useSeries == 1)
		{
			if(firstMarkSeriesIndex <= secondeMarkSeriesIndex)
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
			if(firstMarkSeriesIndex <= secondeMarkSeriesIndex)
			{
				for(int i = firstMarkSeriesIndex; i < secondeMarkSeriesIndex; i++)
				{
					double tempX = series2.getX(i+1).doubleValue() - series2.getX(i).doubleValue();
					double tempY = series2.getY(i+1).doubleValue() + series2.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
				}
			}
			else
			{
				for(int i = secondeMarkSeriesIndex; i < firstMarkSeriesIndex; i++)
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
			if(firstMarkSeriesIndex <= secondeMarkSeriesIndex)
			{
				for(int i = firstMarkSeriesIndex; i < secondeMarkSeriesIndex; i++)
				{
					double tempX = series3.getX(i+1).doubleValue() - series3.getX(i).doubleValue();
					double tempY = series3.getY(i+1).doubleValue() + series3.getY(i).doubleValue();
					totalIntgration = totalIntgration +  tempX *tempY;
				}
			}
			else
			{
				for(int i = secondeMarkSeriesIndex; i < firstMarkSeriesIndex; i++)
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
		frame.setSize(759, 518);
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		dataset = new XYSeriesCollection();
		
		dataset.addSeries(series1);

		lblSeriesS1 = new JLabel("Series 1");
		lblSeriesS1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSeriesS1, "4, 2, 3, 1, center, center");
		
		lblMinimumS1 = new JLabel("Minimum");
		contentPane.add(lblMinimumS1, "4, 4, right, center");
		
		minimumS1 = new JTextField();
		contentPane.add(minimumS1, "6, 4, fill, center");
		minimumS1.setColumns(10);
		
		lblMaximumS1 = new JLabel("Maximum");
		contentPane.add(lblMaximumS1, "4, 6, right, center");
		
		maximumS1 = new JTextField();
		contentPane.add(maximumS1, "6, 6, fill, default");
		maximumS1.setColumns(10);
		
		lblIntegrationS1 = new JLabel("Integration");
		contentPane.add(lblIntegrationS1, "4, 8, right, center");
		
		integrationS1 = new JTextField();
		contentPane.add(integrationS1, "6, 8, fill, default");
		integrationS1.setColumns(10);
		
		
		
		if(seriesNumber > 1)
		{
			dataset.addSeries(series2);
			
			lblSeriesS2 = new JLabel("Series 2");
			lblSeriesS2.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblSeriesS2, "4, 10, 3, 1, center, default");
			
			lblMinimumS2 = new JLabel("Minimum");
			contentPane.add(lblMinimumS2, "4, 12, right, default");
			
			minimumS2 = new JTextField();
			minimumS2.setColumns(10);
			contentPane.add(minimumS2, "6, 12, fill, default");
			
			lblMaximumS2 = new JLabel("Maximum");
			contentPane.add(lblMaximumS2, "4, 14, right, default");
			
			maximumS2 = new JTextField();
			contentPane.add(maximumS2, "6, 14, fill, center");
			maximumS2.setColumns(10);
			
			lblIntegrationS2 = new JLabel("Integration");
			contentPane.add(lblIntegrationS2, "4, 16, right, default");
			
			integrationS2 = new JTextField();
			contentPane.add(integrationS2, "6, 16, fill, default");
			integrationS2.setColumns(10);
		}
		if(seriesNumber > 2)
		{
			dataset.addSeries(series3);
			
			lblSeriesS3 = new JLabel("Series 3");
			lblSeriesS3.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblSeriesS3, "4, 18, 3, 1, center, center");
			
			lblMinimumS3 = new JLabel("Minimum");
			contentPane.add(lblMinimumS3, "4, 20, right, default");
			
			minimumS3 = new JTextField();
			contentPane.add(minimumS3, "6, 20, fill, center");
			minimumS3.setColumns(10);
			
			lblMaximumS3 = new JLabel("Maximum");
			contentPane.add(lblMaximumS3, "4, 22, right, default");
			
			maximumS3 = new JTextField();
			contentPane.add(maximumS3, "6, 22, fill, default");
			maximumS3.setColumns(10);
			
			lblIntegrationS3 = new JLabel("Integration");
			contentPane.add(lblIntegrationS3, "4, 24, right, default");
			
			integrationS3 = new JTextField();
			contentPane.add(integrationS3, "6, 24, fill, default");
			integrationS3.setColumns(10);
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "2, 2, 1, 27, fill, default");
		panel.setLayout(new BorderLayout(0, 0));
		
		CP = new GraphChartPanel(chart);
		
		CP.setMaximumDrawWidth(1023);
		CP.setZoomAroundAnchor(true);
		CP.setHorizontalAxisTrace(false);
		CP.setMouseZoomable(false);
		CP.setRefreshBuffer(true);
		CP.setVerticalAxisTrace(false);
		
		panel.add(CP, BorderLayout.CENTER);
		
		
		
		
		
		
		
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
		//frame.pack();
	}
	
	public void close()
	{
		DataManager.removePayloadUpdateEvent(listener);
	}
}
