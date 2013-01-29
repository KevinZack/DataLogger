package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Componets.Graph.CreateButton;
import Componets.Graph.OpperatorComboBox;
import Componets.Graph.TypeComboBox;
import Componets.MenueItems.SeriesNumberMenuItem;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;


public class CreateGraph extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8583694805080537992L;
	private JPanel contentPane;
	public OpperatorComboBox opperatorComboBoxY1;
	public JComboBox<String> comboSenOneY1;
	public JComboBox<String> comboSenTwoY1;
	public OpperatorComboBox opperatorComboBoxY2;
	public JComboBox<String> comboSenOneY2;
	public JComboBox<String> comboSenTwoY2;
	public OpperatorComboBox opperatorComboBoxY3;
	public JComboBox<String> comboSenOneY3;
	public JComboBox<String> comboSenTwoY3;
	
	public OpperatorComboBox opperatorComboBoxX;
	public JComboBox<String> comboSenOneX;
	public JComboBox<String> comboSenTwoX;
	public TypeComboBox typeComboBox;
	
	public String timeText ;
	public String senOneText;
	public String senTwoText;
	public String senThreeText;
	public String senFourText;
	public String senFiveText;
	public String senSixText;
	public int size;
	
	public CreateButton createButton;
	
	public Window window;
	private JLabel lblYaxis;
	private JLabel lblXaxis;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	private JLabel lblType;
	private JMenuBar menuBar;
	private JMenu mnConfigure;
	private JMenu mnNumberOfSeries;
	private SeriesNumberMenuItem seriesNumberMenuItem;
	
	private JLabel lblSeriesOne;
	private JLabel lblSeriesTwo;
	private JLabel lblSeriesThree;

	public int hight = 340;
	public int length = 500;
	
	public int seriesNumber = 1;
	
	public CreateGraph(Window window) 
	{
		
		this.window = window;
		setTitle("Create Graph");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(500, 340);
		this.setMinimumSize(new Dimension(length,hight));

		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnConfigure = new JMenu("Configure");
		menuBar.add(mnConfigure);
		
		mnNumberOfSeries = new JMenu("Number Of Series");
		mnConfigure.add(mnNumberOfSeries);
		
	
		
		
		seriesNumberMenuItem = new SeriesNumberMenuItem("1");
		mnNumberOfSeries.add(seriesNumberMenuItem);
		seriesNumberMenuItem.setActionListener(this,1);
		seriesNumberMenuItem = new SeriesNumberMenuItem("2");
		mnNumberOfSeries.add(seriesNumberMenuItem);
		seriesNumberMenuItem.setActionListener(this,2);
		seriesNumberMenuItem = new SeriesNumberMenuItem("3");
		mnNumberOfSeries.add(seriesNumberMenuItem);
		seriesNumberMenuItem.setActionListener(this,3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("100px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("70px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("150px:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("24px"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("36px"),
				RowSpec.decode("23px"),}));
		
		

		
		
		lblYaxis = new JLabel("Y-Axis");
		lblYaxis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYaxis.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblYaxis, "3, 2, 5, 1, fill, bottom");
		
		lblSeriesOne = new JLabel("Series One");
		contentPane.add(lblSeriesOne, "1, 6, right, center");
		
		lblSeriesTwo = new JLabel("Series Two");
		contentPane.add(lblSeriesTwo, "1, 8, right, top");
		
		lblSeriesThree = new JLabel("Series Three");
		contentPane.add(lblSeriesThree, "1, 10, right, top");
		
		lblXaxis = new JLabel("X-Axis");
		lblXaxis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXaxis.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblXaxis, "5, 11, fill, top");
		
		label = new JLabel("Sensor One");
		contentPane.add(label, "3, 13, fill, top");
		
		label_1 = new JLabel("Opperator");
		contentPane.add(label_1, "5, 13, fill, top");
		
		label_2 = new JLabel("Sensor Two");
		contentPane.add(label_2, "7, 13, fill, top");
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblType, "3, 17, right, center");
		
		typeComboBox = new TypeComboBox();
		contentPane.add(typeComboBox, "5, 17, fill, center");
		typeComboBox.setActionListener(this);
		typeComboBox.addItem("Line");
		typeComboBox.addItem("Scatter");
		
		
	
		
		JLabel lblSensorOne = new JLabel("Sensor One");
		contentPane.add(lblSensorOne, "3, 4, center, top");
		
		JLabel lblOpperator = new JLabel("Opperator");
		contentPane.add(lblOpperator, "5, 4, center, top");
		
		JLabel lblSensorTwo = new JLabel("Sensor Two");
		contentPane.add(lblSensorTwo, "7, 4, center, top");
		
		createButton = new CreateButton();
		contentPane.add(createButton, "7, 17, fill, top");
		createButton.setActionListener(this);
		
		size = window.size;

		timeText = window.time.getText();
		senOneText = window.sensorOne.getText();
		
		if(size > 1)
		{
			senTwoText = window.sensorTwo.getText();
		}
		if(size > 2)
		{
			senThreeText = window.sensorThree.getText();
		}
		if(size > 3)
		{
			senFourText = window.sensorFour.getText();
		}
		if(size > 4)
		{
			senFiveText = window.sensorFive.getText();
		}
		if(size > 5)
		{
			senSixText = window.sensorSix.getText();
		}
				
		
		comboSenOneX = new JComboBox<String>();
		comboSenOneX.addItem(timeText);
		comboSenOneX.addItem(senOneText);
		
		comboSenTwoX = new JComboBox<String>();
		comboSenTwoX.setEnabled(false);
		comboSenTwoX.addItem(timeText);
		comboSenTwoX.addItem(senOneText);
		
		comboSenOneY1 = new JComboBox<String>();
		comboSenOneY1.addItem(timeText);
		comboSenOneY1.addItem(senOneText);

		comboSenTwoY1 = new JComboBox<String>();
		comboSenTwoY1.setEnabled(false);
		comboSenTwoY1.addItem(timeText);
		comboSenTwoY1.addItem(senOneText);
		
		comboSenOneY2 = new JComboBox<String>();
		comboSenOneY2.addItem(timeText);
		comboSenOneY2.addItem(senOneText);
		
		comboSenTwoY2 = new JComboBox<String>();
		comboSenTwoY2.setEnabled(false);
		comboSenTwoY2.addItem(timeText);
		comboSenTwoY2.addItem(senOneText);
		
		comboSenOneY3 = new JComboBox<String>();
		comboSenOneY3.addItem(timeText);
		comboSenOneY3.addItem(senOneText);
		
		comboSenTwoY3 = new JComboBox<String>();
		comboSenTwoY3.setEnabled(false);
		comboSenTwoY3.addItem(timeText);
		comboSenTwoY3.addItem(senOneText);
		
		
		opperatorComboBoxX = new OpperatorComboBox();
		opperatorComboBoxX.addItem("NA");
		opperatorComboBoxX.addItem("+");
		opperatorComboBoxX.addItem("-");
		opperatorComboBoxX.addItem("*");
		opperatorComboBoxX.addItem("/");
		opperatorComboBoxX.setActionListener(this,comboSenTwoX);
		
		opperatorComboBoxY1 = new OpperatorComboBox();
		opperatorComboBoxY1.addItem("NA");
		opperatorComboBoxY1.addItem("+");
		opperatorComboBoxY1.addItem("-");
		opperatorComboBoxY1.addItem("*");
		opperatorComboBoxY1.addItem("/");
		opperatorComboBoxY1.setActionListener(this,comboSenTwoY1);

		opperatorComboBoxY2 = new OpperatorComboBox();
		opperatorComboBoxY2.addItem("NA");	
		opperatorComboBoxY2.addItem("+");	
		opperatorComboBoxY2.addItem("-");
		opperatorComboBoxY2.addItem("*");
		opperatorComboBoxY2.addItem("/");	
		opperatorComboBoxY2.setActionListener(this,comboSenTwoY2);
		
		opperatorComboBoxY3 = new OpperatorComboBox();
		opperatorComboBoxY3.addItem("NA");
		opperatorComboBoxY3.addItem("+");
		opperatorComboBoxY3.addItem("-");
		opperatorComboBoxY3.addItem("*");
		opperatorComboBoxY3.addItem("/");
		opperatorComboBoxY3.setActionListener(this,comboSenTwoY3);
		
		
	
		
		
		if(size > 1)
		{
			comboSenOneY1.addItem(senTwoText);
			comboSenOneX.addItem(senTwoText);
			comboSenTwoY1.addItem(senTwoText);
			comboSenTwoX.addItem(senTwoText);
			comboSenOneY2.addItem(senTwoText);
			comboSenTwoY2.addItem(senTwoText);	
			comboSenOneY3.addItem(senTwoText);
			comboSenTwoY3.addItem(senTwoText);	
			
		}
		if(size > 2)
		{
			comboSenOneY1.addItem(senThreeText);
			comboSenOneX.addItem(senThreeText);
			comboSenTwoY1.addItem(senThreeText);
			comboSenTwoX.addItem(senThreeText);
			comboSenOneY2.addItem(senThreeText);
			comboSenTwoY2.addItem(senThreeText);	
			comboSenOneY3.addItem(senThreeText);
			comboSenTwoY3.addItem(senThreeText);	
		}
		if(size > 3)
		{
			comboSenOneY1.addItem(senFourText);
			comboSenOneX.addItem(senFourText);
			comboSenTwoY1.addItem(senFourText);
			comboSenTwoX.addItem(senFourText);
			comboSenOneY2.addItem(senFourText);
			comboSenTwoY2.addItem(senFourText);	
			comboSenOneY3.addItem(senFourText);
			comboSenTwoY3.addItem(senFourText);	
		}
		if(size > 4)
		{
			comboSenOneY1.addItem(senFiveText);
			comboSenOneX.addItem(senFiveText);
			comboSenTwoY1.addItem(senFiveText);
			comboSenTwoX.addItem(senFiveText);
			comboSenOneY2.addItem(senFiveText);
			comboSenTwoY2.addItem(senFiveText);	
			comboSenOneY3.addItem(senFiveText);
			comboSenTwoY3.addItem(senFiveText);	
			
		}
		if(size > 5)
		{
			comboSenOneY1.addItem(senSixText);
			comboSenOneX.addItem(senSixText);
			comboSenTwoY1.addItem(senSixText);
			comboSenTwoX.addItem(senSixText);
			comboSenOneY2.addItem(senSixText);
			comboSenTwoY2.addItem(senSixText);	
			comboSenOneY3.addItem(senSixText);
			comboSenTwoY3.addItem(senSixText);	
			
		}
		
		contentPane.add(opperatorComboBoxX, "5, 15, fill, top");
		contentPane.add(opperatorComboBoxY1, "5, 6, fill, top");
		contentPane.add(opperatorComboBoxY2, "5, 8, fill, top");
		contentPane.add(opperatorComboBoxY3, "5, 10, fill, top");
		
		contentPane.add(comboSenOneX, "3, 15, fill, top");
		contentPane.add(comboSenTwoX, "7, 15, fill, top");
		
		contentPane.add(comboSenOneY1, "3, 6, fill, top");
		contentPane.add(comboSenTwoY1, "7, 6, fill, top");
		
		contentPane.add(comboSenOneY2, "3, 8, fill, top");
		contentPane.add(comboSenTwoY2, "7, 8, fill, top");
		
		contentPane.add(comboSenOneY3, "3, 10, fill, top");
		contentPane.add(comboSenTwoY3, "7, 10, fill, top");
		
		enableSeries();
		this.setVisible(true);
	}

	public void changeNumberOfSeries(int number)
	{
		this.seriesNumber = number;
		System.out.println(number);

		enableSeries();
		this.repaint();
	}
	
	public void enableSeries()
	{
		lblSeriesTwo.setEnabled(false);
		comboSenOneY2.setEnabled(false);
		comboSenTwoY2.setEnabled(false);
		opperatorComboBoxY2.setEnabled(false);
		lblSeriesThree.setEnabled(false);
		comboSenOneY3.setEnabled(false);
		comboSenTwoY3.setEnabled(false);
		opperatorComboBoxY3.setEnabled(false);
		
		if(seriesNumber > 1)
		{
			lblSeriesTwo.setEnabled(true);
			comboSenOneY2.setEnabled(true);
			opperatorComboBoxY2.setEnabled(true);
		
		}
		if(seriesNumber > 2)
		{
			lblSeriesThree.setEnabled(true);
			comboSenOneY3.setEnabled(true);
			opperatorComboBoxY3.setEnabled(true);
		}	
	}
}
