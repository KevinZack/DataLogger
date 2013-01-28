package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Parsers.Parsing;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class Errors extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5531720761765797595L;
	private JPanel contentPane;
	private JTextField totalErrors;
	private JLabel lblTotalPoints;
	private JLabel lblError;
	private JTextField percent;
	private JTextField total;
	private Parsing parsing;
	private JLabel lblPeriod;
	private JLabel lblFrequency;
	private JTextField period;
	private JTextField frequency;
	public double lastDataPoint = System.currentTimeMillis();
	public double frequencyNumber;
	public double periodNumber;
	public int count = 0;
	public int countTo = 3;
	private  DecimalFormat df;
	
	public Errors(Parsing parsing) 
	{
		
		this.parsing = parsing;
		df = new DecimalFormat("#.###");
		setTitle("Stream Information");
		this.setVisible(true);
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 273, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("95px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblTotalPoints = new JLabel("Total Points");
		contentPane.add(lblTotalPoints, "1, 1, right, center");
		
		total = new JTextField();
		total.setText("0");
		contentPane.add(total, "3, 1, fill, top");
		total.setColumns(10);
		
		JLabel lblTotalErrors = new JLabel("Total Errors");
		contentPane.add(lblTotalErrors, "1, 3, center, fill");
		
		totalErrors = new JTextField();
		totalErrors.setText("0");
		contentPane.add(totalErrors, "3, 3, fill, fill");
		totalErrors.setColumns(10);
		
		lblError = new JLabel("% Error");
		contentPane.add(lblError, "1, 5, right, default");
		
		percent = new JTextField();
		percent.setText("0");
		contentPane.add(percent, "3, 5, fill, default");
		percent.setColumns(10);	
		
		lblPeriod = new JLabel("Period");
		contentPane.add(lblPeriod, "1, 7, right, default");
		
		period = new JTextField();
		contentPane.add(period, "3, 7, fill, default");
		period.setColumns(10);
		
		lblFrequency = new JLabel("Frequency(Hz)");
		contentPane.add(lblFrequency, "1, 9, right, default");
		
		frequency = new JTextField();
		contentPane.add(frequency, "3, 9, fill, default");
		frequency.setColumns(10);
		
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				close();
			}
		});
		
		
	}
	
	public void close()
	{
		parsing.showErrors = false;
	}

		    
	public void updateErrors(final int errorTotal,final  long totalData, final double lastDataPoint)
	{
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {    	
		    	percent.setText(Double.toString((double)errorTotal/(double)totalData));
				total.setText(Long.toString(totalData));
				totalErrors.setText(Integer.toString(errorTotal));
				periodNumber = (double) (lastDataPoint - getLastData())/1000.;
				if(periodNumber != 0)
				{
					frequencyNumber = 1.0/periodNumber;
				}
				
				if(setCount())
				{
					period.setText(df.format(periodNumber));
					frequency.setText(df.format(frequencyNumber));
				}
				setLastDataPoint(lastDataPoint);
		    }
		 });
	}
	
	public boolean setCount()
	{
		boolean returnStatement = false;
		if(count > 15)
		{
			count  = 0;
			returnStatement = true;
		}
		else
		{
			count++;
		}
		return returnStatement;
		
	}
	public void setLastDataPoint(double lastDataPoint)
	{
		this.lastDataPoint = lastDataPoint;
		
	}
	public double getLastData()
	{
		return lastDataPoint;
	}
}

