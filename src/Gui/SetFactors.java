package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Componets.SetFactors.CancelButton;
import Componets.SetFactors.SaveButton;
import Parsers.Parsing;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class SetFactors extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6707821690476610910L;
	private JPanel contentPane;
	public Parsing parsing;
	private JTextField curTime;
	private JTextField curSenOne;
	private JTextField curSenTwo;
	private JTextField curSenThree;
	private JTextField curSenFour;
	private JTextField curSenFive;
	private JTextField curSenSix;
	
	public JTextField changeTime;
	public JTextField changeSenOne;
	public JTextField changeSenTwo;
	public JTextField changeSenThree;
	public JTextField changeSenFour;
	public JTextField changeSenFive;
	public JTextField changeSenSix;

	public SaveButton saveButton;
	public CancelButton cancelButton;
	
	public double timeFactor;
	public double sensorOneFactor;
	public double sensorTwoFactor;
	public double sensorThreeFactor;
	public double sensorFourFactor;
	public double sensorFiveFactor;
	public double sensorSixFactor;
	
	public Window window;
	public int size = 0;

	
	public SetFactors(Parsing parsing, Window window) {
		setTitle("Set Factors");
		this.window = window;
		this.parsing = parsing;
		this.size = parsing.size;
		this.setLocation(50, 50);

		this.setVisible(true);

		timeFactor = parsing.timeFactor;
		sensorOneFactor = parsing.sensorOneFactor;
		sensorTwoFactor = parsing.sensorTwoFactor;
		sensorThreeFactor = parsing.sensorThreeFactor;
		sensorFourFactor = parsing.sensorFourFactor;
		sensorFiveFactor = parsing.sensorFiveFactor;
		sensorSixFactor = parsing.sensorSixFactor;

		int verticalSize = 135+ (size)*30;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(355,verticalSize);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String rowThree = "15dlu";
		String rowSubThree = "4dlu";
		String rowFour = "15dlu";
		String rowSubFour = "4dlu";
		String rowFive = "15dlu";
		String rowSubFive = "4dlu";
		String rowSix = "15dlu";
		String rowSubSix = "4dlu";
		String rowSeven = "15dlu";
		String rowSubSeven = "4dlu";
		
		if(size < 2)
		{
			rowThree = "0px";
			rowSubThree = "0px";
		}
		if(size < 3)
		{
			rowFour = "0px";
			rowSubFour = "0px";
		}
		if(size < 4)
		{
			rowFive = "0px";
			 rowSubFive = "0px";
		}
		if(size < 5)
		{
			rowSix = "0px";
			rowSubSix = "0px";
		}
		if(size < 6)
		{
			rowSeven = "0px";
			rowSubSeven = "0px";
		}
		
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("1px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode(rowThree),
				RowSpec.decode(rowSubThree),
				RowSpec.decode(rowFour),
				RowSpec.decode(rowSubFour),
				RowSpec.decode(rowFive),
				RowSpec.decode(rowSubFive),
				RowSpec.decode(rowSix),
				RowSpec.decode(rowSubSix),
				RowSpec.decode(rowSeven),
				RowSpec.decode(rowSubSeven),
				RowSpec.decode("20dlu"),}));
		

		JLabel lblCurrent = new JLabel("Current");
		contentPane.add(lblCurrent, "4, 2");

		JLabel lblChangeTo = new JLabel("Change To");
		contentPane.add(lblChangeTo, "8, 2");

		/*******************************************************************/
		
		curTime = new JTextField();
		curTime.setBackground(Color.WHITE);
		curTime.setEditable(false);
		contentPane.add(curTime, "4, 4, fill, default");
		curTime.setColumns(10);
		curTime.setText(Double.toString(timeFactor));
		
		JLabel lblTime = new JLabel("Time");
		
		contentPane.add(lblTime, "2, 4");
		
		changeTime = new JTextField();
		contentPane.add(changeTime, "8, 4, fill, default");
		changeTime.setColumns(10);
		
		/*******************************************************************/	
		
		curSenOne = new JTextField();
		curSenOne.setBackground(Color.WHITE);
		curSenOne.setEditable(false);
		contentPane.add(curSenOne, "4, 6, fill, default");
		curSenOne.setColumns(10);
		curSenOne.setText(Double.toString(sensorOneFactor));

		changeSenOne = new JTextField();
		contentPane.add(changeSenOne, "8, 6, fill, default");
		changeSenOne.setColumns(10);

		JLabel lblSensor_1 = new JLabel(window.sensorOne.getText());
		
		contentPane.add(lblSensor_1, "2, 6");
		/*******************************************************************/
		if(size > 1)
		{
			curSenTwo = new JTextField();
			curSenTwo.setEditable(false);
			curSenTwo.setBackground(Color.WHITE);
			
			contentPane.add(curSenTwo, "4, 8, fill, default");
			curSenTwo.setColumns(10);
			curSenTwo.setText(Double.toString(sensorTwoFactor));
	
			changeSenTwo = new JTextField();
			contentPane.add(changeSenTwo, "8, 8, fill, default");
			changeSenTwo.setColumns(10);
	
			JLabel lblSensor_2 = new JLabel(window.sensorTwo.getText());
			contentPane.add(lblSensor_2, "2, 8");
		}
		/*******************************************************************/
		if(size > 2)
		{
			curSenThree = new JTextField();
			curSenThree.setEditable(false);
			curSenThree.setBackground(Color.WHITE);

			contentPane.add(curSenThree, "4, 10, fill, default");
			curSenThree.setColumns(10);
			curSenThree.setText(Double.toString(sensorThreeFactor));
	
			changeSenThree = new JTextField();
			contentPane.add(changeSenThree, "8, 10, fill, default");
			changeSenThree.setColumns(10);
	
			JLabel lblSensor_3 = new JLabel(window.sensorThree.getText());
			contentPane.add(lblSensor_3, "2, 10");
		}
		/*******************************************************************/
		if(size > 3)
		{
			curSenFour = new JTextField();
			curSenFour.setEditable(false);
			curSenFour.setBackground(Color.WHITE);
			contentPane.add(curSenFour, "4, 12, fill, default");
			curSenFour.setColumns(10);
			curSenFour.setText(Double.toString(sensorFourFactor));
	
			changeSenFour = new JTextField();
			changeSenFour.setToolTipText("");
			contentPane.add(changeSenFour, "8, 12, fill, default");
			changeSenFour.setColumns(10);
	
			JLabel lblSensor_4 = new JLabel(window.sensorFour.getText());
			
			contentPane.add(lblSensor_4, "2, 12");
		}
		/*******************************************************************/
		if(size > 4)
		{
			curSenFive = new JTextField();
			contentPane.add(curSenFive, "4, 14, fill, default");
			curSenFive.setEditable(false);
			curSenFive.setBackground(Color.WHITE);

			curSenFive.setColumns(10);
			curSenFive.setText(Double.toString(sensorFiveFactor));
			
			changeSenFive = new JTextField();
			contentPane.add(changeSenFive, "8, 14, fill, default");
			changeSenFive.setColumns(10);
	
			JLabel lblSensor_5 = new JLabel(window.sensorFive.getText());
			contentPane.add(lblSensor_5, "2, 14");
		}
		/******************************************************************/
		if(size > 5)
		{
			curSenSix = new JTextField();
			contentPane.add(curSenSix, "4, 16, fill, default");
			curSenSix.setEditable(false);
			curSenSix.setBackground(Color.WHITE);

			curSenSix.setColumns(10);
			curSenSix.setText(Double.toString(sensorSixFactor));
			changeSenSix = new JTextField();
			contentPane.add(changeSenSix, "8, 16, fill, default");
			changeSenSix.setColumns(10);
	
			JLabel lblSensor_6 = new JLabel(window.sensorSix.getText());
			contentPane.add(lblSensor_6, "2, 16");
		}
/*******************************************************************/
		
		cancelButton = new CancelButton();
		contentPane.add(cancelButton, "4, 18");
		cancelButton.setActionListener(this);

		saveButton = new SaveButton();
		contentPane.add(saveButton, "8, 18");
		saveButton.setActionListener(parsing, this);

	}
}
