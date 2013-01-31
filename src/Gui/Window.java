package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Componets.Graph.GraphButtonMenuItem;
import Componets.MenueItems.DecimalPacesMenuItem;
import Componets.MenueItems.ResetAveMenuItem;
import Componets.MenueItems.ResetMinMaxMenuItem;
import Componets.MenueItems.SetFactorsMenuItem;
import Componets.MenueItems.ShowErrorsMenuItem;
import Componets.Resets.RecordButton;
import Componets.Resets.StartStopButton;
import Data.Data;
import Events.IPayloadUpdateUpdateGraphEventListener;
import Events.PayloadUpdateGraphEvent;
import Main.DataManager;
import Parsers.DataWriter;
import Parsers.Parsing;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.text.DecimalFormat;

public class Window extends JFrame
{
	private static final long serialVersionUID = 3363174406354567246L;
	private JPanel contentPane;
	public JTextField time;
	
	public JTextField sensorOne;
	public JTextField sensorTwo;
	public JTextField sensorThree;
	public JTextField sensorFour;
	public JTextField sensorFive;
	public JTextField sensorSix;
	
	private JTextField sensorOneMax;
	private JTextField sensorTwoMax;
	private JTextField sensorThreeMax;
	private JTextField sensorFourMax;
	private JTextField sensorFiveMax;
	private JTextField sensorSixMax;
	
	private JTextField sensorOneMin;
	private JTextField sensorTwoMin;
	private JTextField sensorThreeMin;
	private JTextField sensorFourMin;
	private JTextField sensorFiveMin;
	private JTextField sensorSixMin;
	
	public JTextField sensorOneAve;
	public JTextField sensorTwoAve;
	public JTextField sensorThreeAve;
	public JTextField sensorFourAve;
	public JTextField sensorFiveAve;
	public JTextField sensorSixAve;
	
	private JTextField timeArea;
	private JTextField sensorOneArea;
	private JTextField sensorTwoArea;
	private JTextField sensorThreeArea;
	private JTextField sensorFourArea;
	private JTextField sensorFiveArea;
	private JTextField sensorSixArea;

	private JTextArea txtrDataloggerV;
	public boolean takeData = true;
	public boolean record = false;
	public boolean createRecord = true;
	
	public double sensorOneMaxValue = 0;
	public double sensorOneMinValue = 1000;
	public double sensorTwoMaxValue = 0;
	public double sensorTwoMinValue = 1000;	
	public double sensorThreeMaxValue = 0;
	public double sensorThreeMinValue = 1000;
	public double sensorFourMaxValue = 0;
	public double sensorFourMinValue = 1000;
	public double sensorFiveMaxValue = 0;
	public double sensorFiveMinValue = 1000;
	public double sensorSixMaxValue = 0;
	public double sensorSixMinValue = 1000;
	
	private JMenuBar menuBar;
	private JMenu mnGraph;
	private JMenu mnConfigure;
	private JMenu mnReset;
	private JMenu mnAbout;
	private ResetAveMenuItem resetAveMenuItem;
	private ResetMinMaxMenuItem resetMinMaxMenuItem;
	private SetFactorsMenuItem setFactorsMenuItem;
	public GraphButtonMenuItem graphButtonMenuItem;
	public ShowErrorsMenuItem showErrorsMenuItem;
	public StartStopButton startStopButton;
	public RecordButton recordButton;
	
	private  DecimalFormat df;
	public int size = 0;
	
	private Parsing parsing;
	public DataWriter dataWriter;
	private JMenu mnErrors;
	private JMenu mnPresision;
	private DecimalPacesMenuItem decimalPlaceMenuItemZero;
	private DecimalPacesMenuItem decimalPlaceMenuItemOne;
	private DecimalPacesMenuItem decimalPlaceMenuItemTwo;
	private DecimalPacesMenuItem decimalPlaceMenuItemThree;
	private DecimalPacesMenuItem decimalPlaceMenuItemFour;
	private DecimalPacesMenuItem decimalPlaceMenuItemFive;
	
	public Window(Parsing parsing) 
	{
		this.parsing = parsing;
		this.size = parsing.size;
		
		df = new DecimalFormat("#.###");
		setTitle("Terminal Window");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		int minSizeHorzontal = 300 +(40*(size-1));
		this.setSize(803, 230);
		
		this.setResizable(false);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnGraph = new JMenu("Graph");
		menuBar.add(mnGraph);
		
		
		
		graphButtonMenuItem = new GraphButtonMenuItem("Create Graph");
		mnGraph.add(graphButtonMenuItem);
		graphButtonMenuItem.setActionListener(this);
		
		mnConfigure = new JMenu("Configure");
		menuBar.add(mnConfigure);
		
		setFactorsMenuItem = new SetFactorsMenuItem();
		mnConfigure.add(setFactorsMenuItem);
		
		mnPresision = new JMenu("Number Of Decimal Places");
		mnConfigure.add(mnPresision);
		
		decimalPlaceMenuItemZero = new DecimalPacesMenuItem("0");
		mnPresision.add(decimalPlaceMenuItemZero);
		decimalPlaceMenuItemZero.setActionListener(0, this);

		decimalPlaceMenuItemOne = new DecimalPacesMenuItem("1");
		mnPresision.add(decimalPlaceMenuItemOne);
		decimalPlaceMenuItemOne.setActionListener(1, this);
		
		decimalPlaceMenuItemTwo = new DecimalPacesMenuItem("2");
		mnPresision.add(decimalPlaceMenuItemTwo);
		decimalPlaceMenuItemTwo.setActionListener(2, this);
		
		decimalPlaceMenuItemThree = new DecimalPacesMenuItem("3");
		mnPresision.add(decimalPlaceMenuItemThree);
		decimalPlaceMenuItemThree.setActionListener(3, this);
		
		decimalPlaceMenuItemFour = new DecimalPacesMenuItem("4");
		mnPresision.add(decimalPlaceMenuItemFour);
		decimalPlaceMenuItemFour.setActionListener(4, this);
		
		decimalPlaceMenuItemFive = new DecimalPacesMenuItem("5");
		mnPresision.add(decimalPlaceMenuItemFive);
		decimalPlaceMenuItemFive.setActionListener(5, this);
		
		
		
		mnReset = new JMenu("Reset");
		menuBar.add(mnReset);
		
		setFactorsMenuItem.setActionListener(parsing,this);
		
		resetAveMenuItem = new ResetAveMenuItem();
		mnReset.add(resetAveMenuItem);
		resetAveMenuItem.setActionListener(parsing);
		
		resetMinMaxMenuItem = new ResetMinMaxMenuItem();
		mnReset.add(resetMinMaxMenuItem);
		resetMinMaxMenuItem.setActionListener(this);
		
		mnErrors = new JMenu("Errors");
		menuBar.add(mnErrors);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		txtrDataloggerV = new JTextArea();
		String aboutString = "DataLogger V1.0\n";
		aboutString +=       "_______________\n";
		aboutString += 		 "Author: Kevin Zack\n";
		aboutString += 		 "_______________\n";
		aboutString +=       "Libarys Used:  \n";
		aboutString +=       "RXTXcomm \n";
		aboutString +=       "froms-1.3.0 \n";
		aboutString +=       "JFreeChart  \n";
		aboutString +=       "JFreeCommon \n";
		aboutString += 		 "_______________\n";
		aboutString += 		 "Questions? Comments?\n";
		aboutString += 		 "KZackelectric@gmail.com";
		
		txtrDataloggerV.setText(aboutString);
		mnAbout.add(txtrDataloggerV);
		
		
		showErrorsMenuItem = new ShowErrorsMenuItem();
		mnErrors.add(showErrorsMenuItem);
		showErrorsMenuItem.setActionListener(parsing, this);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		String colOne = "max(70dlu;default):grow";
		String colTwo = "max(70dlu;default):grow";
		String colThree = "max(70dlu;default):grow";
		String colThreeSub = "max(4dlu;default)";
		String colFour = "max(70dlu;default):grow";
		String colFourSub = "max(4dlu;default)";
		String colFive = "max(70dlu;default):grow";
		String colFiveSub = "max(4dlu;default)";
		String colSix = "max(70dlu;default):grow";
		String colSixSub = "max(4dlu;default)";
		String colSeven = "max(70dlu;default):grow";

		
		if(size < 2)
		{
			colThree = "max(0dlu;default)";
			colThreeSub = "max(0dlu;default)";
		}
		if(size < 3)
		{
			colFour = "max(0dlu;default)";
			colFourSub = "max(0dlu;default)";
		}
		if(size < 4)
		{
			colFive = "max(0dlu;default)";
			colFiveSub = "max(0dlu;default)";
		}
		if(size < 5)
		{
			colSix = "max(0dlu;default)";
			colSixSub = "max(0dlu;default)";
		}
		if(size < 6)
		{
			 colSeven = "max(0dlu;default)";
		}
		
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(colOne),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(colTwo),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(colThree),
				ColumnSpec.decode(colThreeSub),
				ColumnSpec.decode(colFour),
				ColumnSpec.decode(colFourSub),
				ColumnSpec.decode(colFive),
				ColumnSpec.decode(colFiveSub),
				ColumnSpec.decode(colSix),
				ColumnSpec.decode(colSixSub),
				ColumnSpec.decode(colSeven),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		time = new JTextField();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setText("Time");
		time.setColumns(10);
		contentPane.add(time, "2, 2, fill, default");
		
/************************************************************************/				
		sensorOne = new JTextField();
		sensorOne.setHorizontalAlignment(SwingConstants.CENTER);
		sensorOne.setText("Sensor One");
		contentPane.add(sensorOne, "4, 2, fill, default");
		sensorOne.setColumns(10);
		
		timeArea = new JTextField();
		contentPane.add(timeArea, "2, 4");
		timeArea.setColumns(1);
		
		sensorOneArea = new JTextField();
		contentPane.add(sensorOneArea, "4, 4");
		
		sensorOneMax = new JTextField();
		sensorOneMax.setEditable(false);
		contentPane.add(sensorOneMax, "4, 6, fill, default");
		sensorOneMax.setColumns(10);
		
		sensorOneMin = new JTextField();
		sensorOneMin.setEditable(false);
		contentPane.add(sensorOneMin, "4, 8, fill, default");
		sensorOneMin.setColumns(10);
		
		sensorOneAve = new JTextField();
		sensorOneAve.setEditable(false);
		contentPane.add(sensorOneAve, "4, 10, fill, default");
		sensorOneAve.setColumns(10);
		
/************************************************************************/		
		if(size > 1)
		{
			sensorTwo = new JTextField();
			sensorTwo.setHorizontalAlignment(SwingConstants.CENTER);
			sensorTwo.setText("Sensor Two");
			contentPane.add(sensorTwo, "6, 2, fill, default");
			sensorTwo.setColumns(10);
			
			sensorTwoArea = new JTextField();
			contentPane.add(sensorTwoArea, "6, 4, fill, fill");
			
//			sensorTwoArea = new JTextArea();
//			SensorTwoScroll.setViewportView(sensorTwoArea);
			
			sensorTwoMax = new JTextField();
			sensorTwoMax.setEditable(false);
			contentPane.add(sensorTwoMax, "6, 6, fill, default");
			sensorTwoMax.setColumns(10);
			
			sensorTwoMin = new JTextField();
			sensorTwoMin.setEditable(false);
			contentPane.add(sensorTwoMin, "6, 8, fill, default");
			sensorTwoMin.setColumns(10);
			
			sensorTwoAve = new JTextField();
			sensorTwoAve.setEditable(false);
			contentPane.add(sensorTwoAve, "6, 10, fill, default");
			sensorTwoAve.setColumns(10);
		}
/************************************************************************/			
		if(size > 2)
		{
			sensorThree = new JTextField();
			sensorThree.setText("Sensor Three");
			sensorThree.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(sensorThree, "8, 2, fill, default");
			sensorThree.setColumns(10);
	
			sensorThreeArea = new JTextField();
			contentPane.add(sensorThreeArea, "8, 4, fill, fill");
			
//			sensorThreeArea = new JTextArea();
//			SensorThreeScroll.setViewportView(sensorThreeArea);
			
			sensorThreeMax = new JTextField();
			sensorThreeMax.setEditable(false);
			contentPane.add(sensorThreeMax, "8, 6, fill, default");
			sensorThreeMax.setColumns(10);
			
			sensorThreeMin = new JTextField();
			sensorThreeMin.setEditable(false);
			contentPane.add(sensorThreeMin, "8, 8, fill, default");
			sensorThreeMin.setColumns(10);
			
			sensorThreeAve = new JTextField();
			sensorThreeAve.setEditable(false);
			contentPane.add(sensorThreeAve, "8, 10, fill, default");
			sensorThreeAve.setColumns(10);
		}
/************************************************************************/				
		if(size > 3)
		{
			sensorFour = new JTextField();
			sensorFour.setHorizontalAlignment(SwingConstants.CENTER);
			sensorFour.setText("Sensor Four");
			contentPane.add(sensorFour, "10, 2, fill, default");
			sensorFour.setColumns(10);
			
			sensorFourArea = new JTextField();
			contentPane.add(sensorFourArea, "10, 4, fill, fill");
			
//			sensorFourArea = new JTextArea();
//			SensorFourScroll.setViewportView(sensorFourArea);
			
			sensorFourMax = new JTextField();
			sensorFourMax.setEditable(false);
			contentPane.add(sensorFourMax, "10, 6, fill, default");
			sensorFourMax.setColumns(10);
			
			sensorFourMin = new JTextField();
			sensorFourMin.setEditable(false);
			contentPane.add(sensorFourMin, "10, 8, fill, default");
			sensorFourMin.setColumns(10);
			
			sensorFourAve = new JTextField();
			sensorFourAve.setEditable(false);
			contentPane.add(sensorFourAve, "10, 10, fill, default");
			sensorFourAve.setColumns(10);
		}
/************************************************************************/				
		if(size > 4)
		{
		sensorFive = new JTextField();
		sensorFive.setText("Sensor Five");
		sensorFive.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(sensorFive, "12, 2, fill, default");
		sensorFive.setColumns(10);
		
		sensorFiveArea = new JTextField();
		contentPane.add(sensorFiveArea, "12, 4, fill, fill");
		
//		sensorFiveArea = new JTextArea();
//		SensorFiveScroll.setViewportView(sensorFiveArea);
//		
		sensorFiveMax = new JTextField();
		sensorFiveMax.setEditable(false);
		contentPane.add(sensorFiveMax, "12, 6, fill, default");
		sensorFiveMax.setColumns(10);
		
		sensorFiveMin = new JTextField();
		sensorFiveMin.setEditable(false);
		contentPane.add(sensorFiveMin, "12, 8, fill, default");
		sensorFiveMin.setColumns(10);
		
		sensorFiveAve = new JTextField();
		sensorFiveAve.setEditable(false);
		contentPane.add(sensorFiveAve, "12, 10, fill, default");
		sensorFiveAve.setColumns(10);

/************************************************************************/			
		
		}
		if(size > 5)
		{
		sensorSix = new JTextField();
		sensorSix.setText("Sensor Six");
		contentPane.add(sensorSix, "14, 2, fill, default");
		sensorSix.setHorizontalAlignment(SwingConstants.CENTER);
		sensorSix.setColumns(10);
		
		sensorSixArea = new JTextField();
		contentPane.add(sensorSixArea, "14, 4, fill, fill");
		
//		sensorSixArea = new JTextArea();
//		SensorSixScroll.setViewportView(sensorSixArea);
		
		sensorSixMax = new JTextField();
		sensorSixMax.setEditable(false);
		contentPane.add(sensorSixMax, "14, 6, fill, default");
		sensorSixMax.setColumns(10);
		
		sensorSixMin = new JTextField();
		sensorSixMin.setEditable(false);
		contentPane.add(sensorSixMin, "14, 8, fill, default");
		sensorSixMin.setColumns(10);
		
		sensorSixAve = new JTextField();
		sensorSixAve.setEditable(false);
		contentPane.add(sensorSixAve, "14, 10, fill, default");
		sensorSixAve.setColumns(10);
		}
		
		
		
/************************************************************************/	
		JLabel lblMaximum = new JLabel("Maximum");
		contentPane.add(lblMaximum, "2, 6, right, default");

		JLabel lblMinimum = new JLabel("Minimum");
		contentPane.add(lblMinimum, "2, 8, right, default");

		JLabel lblAverage = new JLabel("Average");
		contentPane.add(lblAverage, "2, 10, right, default");
		
		startStopButton = new StartStopButton();
		startStopButton.setSelected(true);
		contentPane.add(startStopButton, "2, 12");
		startStopButton.setActionListener(this);
		startStopButton.setText("Started");
		
		recordButton = new RecordButton();
		contentPane.add(recordButton, "4, 12");
		recordButton.setActionListener(this);
		recordButton.setText("Not Recording");
		
		
		pack();
		setVisible(true);
/************************************************************************/	
		
		
		
	}
	
	
	public void record (boolean record) 
	{
		this.record = record;
		if(createRecord)
		{
			 dataWriter = new DataWriter("Formated");
			 createRecord = false;
		}
	}
	
	public void setDecimalPlaces(int number)
	{
		switch (number)
		{
		case 0: df = new DecimalFormat("#.");
				break;
		case 1: df = new DecimalFormat("#.#");
				break;
		case 2: df = new DecimalFormat("#.##");
				break;
		case 3: df = new DecimalFormat("#.###");
				break;
		case 4: df = new DecimalFormat("#.####");
				break;
		case 5: df = new DecimalFormat("#.#####");
				break;
		}
	}
	public void updateData(final Data data) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {
		    	if(takeData)
		    	{
			    	//timeArea.append(df.format(data.time)+"\n");
			    	timeArea.setText(df.format(data.time)+"\n");
			    	
			    	timeArea.setCaretPosition(timeArea.getDocument().getLength());
			    		
			    	String tempString = "";
		    		tempString += data.time;
		    		tempString += ",";
		    		tempString += df.format(data.sensorOne);
			    	
			    	if(data.sensorOne > sensorOneMaxValue)
			    	{
			    		sensorOneMaxValue = data.sensorOne;
			    		sensorOneMax.setText(df.format(data.sensorOne));
			    		
			    	}
			    	if(data.sensorOne < sensorOneMinValue)
			    	{
			    		sensorOneMinValue = data.sensorOne;
			    		sensorOneMin.setText(df.format(data.sensorOne));
			    	}
			    	
			    	//sensorOneArea.append(df.format(data.sensorOne)+"\n");
			    	sensorOneArea.setText(df.format(data.sensorOne)+"\n");
			    	sensorOneAve.setText(df.format((double)parsing.totalSensorOne/parsing.totalEntries));
			    	sensorOneArea.setCaretPosition(sensorOneArea.getDocument().getLength());
			    	
			    	
			    	if(size > 1)
			    	{
				    	if(data.sensorTwo > sensorTwoMaxValue)
				    	{
				    		sensorTwoMaxValue = data.sensorTwo;
				    		sensorTwoMax.setText(df.format(data.sensorThree));
				    	}
				    	if(data.sensorTwo < sensorTwoMinValue && size > 1)
				    	{
				    		sensorTwoMinValue = data.sensorTwo;
				    		sensorTwoMin.setText(df.format(data.sensorThree));
				    	}
				    	
				    	sensorTwoArea.setText(df.format(data.sensorTwo)+"\n");
				    	sensorTwoAve.setText(df.format((double)parsing.totalSensorTwo/parsing.totalEntries));
				    	sensorTwoArea.setCaretPosition(sensorTwoArea.getDocument().getLength());
				    	tempString += ",";
			    		tempString += df.format(data.sensorTwo);	
			    	}
			    	
			    	if(size > 2)
					{	
				    	if(data.sensorThree > sensorThreeMaxValue && size > 2)
				    	{
				    		sensorThreeMaxValue = data.sensorThree;
				    		sensorThreeMax.setText(df.format(data.sensorThree));
				    	}
				    	if(data.sensorThree < sensorThreeMinValue && size > 2)
				    	{
				    		sensorThreeMinValue = data.sensorThree;
				    		sensorThreeMin.setText(df.format(data.sensorThree));
				    	}
				    	
				    	sensorThreeArea.setText(df.format(data.sensorThree)+"\n");
			    		sensorThreeAve.setText(df.format((double)parsing.totalSensorThree/parsing.totalEntries));
			    		sensorThreeArea.setCaretPosition(sensorThreeArea.getDocument().getLength());
				    	tempString += ",";
			    		tempString += df.format(data.sensorThree);
					}
			    	
			    	if(size > 3)
					{
				    	if(data.sensorFour > sensorFourMaxValue && size > 3)
				    	{
				    		sensorFourMaxValue = data.sensorFour;
				    		sensorFourMax.setText(df.format(data.sensorFour));
				    	}
				    	if(data.sensorFour < sensorFourMinValue && size > 3)
				    	{
				    		sensorFourMinValue = data.sensorFour;
				    		sensorFourMin.setText(df.format(data.sensorFour));
				    	}
				    	sensorFourArea.setText(df.format(data.sensorFour)+"\n");
				    	sensorFourAve.setText(df.format((double)parsing.totalSensorFour/parsing.totalEntries));
				    	sensorFourArea.setCaretPosition(sensorFourArea.getDocument().getLength());
				    	tempString += ",";
				    	tempString += df.format(data.sensorFour);
					}
			    	
			    	if(size > 4)
					{
			    		if(data.sensorFive > sensorFiveMaxValue)
				    	{
				    		sensorFiveMaxValue = data.sensorFive;
				    		sensorFiveMax.setText(df.format(data.sensorFive));
				    	}
				    	if(data.sensorFive < sensorFiveMinValue)
				    	{
				    		sensorFiveMinValue = data.sensorFive;
				    		sensorFiveMin.setText(df.format(data.sensorFive));
				    	}
				    	sensorFiveArea.setText(df.format(data.sensorFive)+"\n");
				    	sensorFiveAve.setText(df.format((double)parsing.totalSensorFive/parsing.totalEntries));
				    	sensorFiveArea.setCaretPosition(sensorFiveArea.getDocument().getLength());
				    	tempString += ",";
				    	tempString += df.format(data.sensorFive);
					}
			    	
			    	if(size > 5)
					{
			    		if(data.sensorSix > sensorSixMaxValue)
				    	{
				    		sensorSixMaxValue = data.sensorSix;
				    		sensorSixMax.setText(df.format(data.sensorSix));
				    	}
				    	if(data.sensorSix < sensorSixMinValue)
				    	{
				    		sensorSixMinValue = data.sensorSix;
				    		sensorSixMin.setText(df.format(data.sensorSix));
				    	}
				    	sensorSixArea.setText(df.format(data.sensorSix)+"\n");
				    	sensorSixAve.setText(df.format((double)parsing.totalSensorSix/parsing.totalEntries));
				    	sensorSixArea.setCaretPosition(sensorSixArea.getDocument().getLength());
				    	tempString += ",";
				    	tempString += df.format(data.sensorSix);
					}
			    	
			    	PayloadUpdateGraphEvent complete = new PayloadUpdateGraphEvent(this, data);
			    	Object[] listeners = DataManager.listenerList.getListenerList(); 
			       	for (int i=0; i<listeners.length; i+=2) 
			       	{
			       		if (listeners[i]==IPayloadUpdateUpdateGraphEventListener.class)
			            {
			       			((IPayloadUpdateUpdateGraphEventListener)listeners[i+1]).PayloadUpdateUpdateEventHandeler(complete);
			            }
			        } 	

			    	if(record)
			    	{
			    		dataWriter.run(tempString);
			    	}
			    		
		    	}
		    }
		  });
		}

}
