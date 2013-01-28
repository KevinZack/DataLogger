package Graph;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import org.jfree.data.xy.XYSeries;

public class GraphData {

	private JPanel contentPane;
	public JFrame frame;
	private String title;
	public int seriesNumber=4;
	private JLabel lblMaxSeries1;
	private JTextField SeriesOneMaxField;
	private JLabel lblSeriestwoMax;
	private JTextField SeriesTwoMaxField;
	private JLabel lblSeriesThreeMax;
	private JTextField SeriesThreeMaxField;
	private JLabel lblSeriesOneMin;
	private JTextField SeriesOneMinField;
	private JLabel lblSeriesTwoMin;
	private JLabel lblSeriesThreeMin;
	private JTextField SeriesTwoMinField;
	private JTextField SeriesThreeMinField;
	private JLabel lblSeriesOneIntegration;
	private JTextField SeriesOneIntegration;
	private JLabel lblSeriesTwoIntegration;
	private JTextField SeriesTwoIntegration;
	private JLabel lblSeriesThreeIntegration;
	private JTextField SeriesThreeIntegration;
	private  DecimalFormat df;
	
	public GraphData(String title, int seriesNumber) 
	{
		this.title = title;
		this.seriesNumber = seriesNumber;
		createGraph();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createGraph()
	{
		df = new DecimalFormat("#.####");
		
		frame = new JFrame("Data for " + title);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		int verticalSize = 135 + (seriesNumber-1)*95;
		
		frame.setSize(270, verticalSize);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		frame.setContentPane(contentPane);
		

		
		String rowSeven = "15dlu";
		String rowSubSeven = "4dlu";
		String rowEight = "15dlu";
		String rowSubEight = "4dlu";
		String rowNine = "15dlu";
		String rowSubNine = "6dlu";
		
		String rowTen = "15dlu";
		String rowSubTen = "4dlu";
		String rowEleven = "15dlu";
		String rowSubEleven = "4dlu";
		String rowTwelve = "15dlu";
		String rowSubTweleve = "4dlu";
		
		
		
		
		if(seriesNumber < 2)
		{
			rowSeven = "0px";
			rowSubSeven = "0px";
			rowEight = "0px";
			rowSubEight = "0px";
			rowNine = "0px";
			rowSubNine = "0px";
		}
		if(seriesNumber < 3)
		{
			rowTen = "0px";
			rowSubTen = "0px";
			rowEleven = "0px";
			rowSubEleven = "0px";
			rowTwelve = "0px";
			rowSubTweleve = "0px";
		}
			
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(77dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15dlu"),
				RowSpec.decode("6dlu"),
				RowSpec.decode(rowSeven),
				RowSpec.decode(rowSubSeven),
				RowSpec.decode(rowEight),
				RowSpec.decode(rowSubEight),
				RowSpec.decode(rowNine),
				RowSpec.decode(rowSubNine),
				RowSpec.decode(rowTen),
				RowSpec.decode(rowSubTen),
				RowSpec.decode(rowEleven),
				RowSpec.decode(rowSubEleven),
				RowSpec.decode(rowTwelve),
				RowSpec.decode(rowSubTweleve),}));
		
		lblMaxSeries1 = new JLabel("Series One Max");
		contentPane.add(lblMaxSeries1, "1, 1, right, fill");
		
		SeriesOneMaxField = new JTextField();
		contentPane.add(SeriesOneMaxField, "3, 1, fill, fill");
		SeriesOneMaxField.setColumns(10);
		
		lblSeriesOneMin = new JLabel("Series One Min");
		contentPane.add(lblSeriesOneMin, "1, 3, right, fill");
		
		SeriesOneMinField = new JTextField();
		contentPane.add(SeriesOneMinField, "3, 3, fill, fill");
		SeriesOneMinField.setColumns(10);
		
		lblSeriesOneIntegration = new JLabel("Series One Integration");
		contentPane.add(lblSeriesOneIntegration, "1, 5, right, fill");
		
		SeriesOneIntegration = new JTextField();
		contentPane.add(SeriesOneIntegration, "3, 5, fill, fill");
		SeriesOneIntegration.setColumns(10);
			

			
		if(seriesNumber>1)
		{
				lblSeriestwoMax = new JLabel("SeriesTwo Max");
				contentPane.add(lblSeriestwoMax, "1, 7, right, default");
				
				SeriesTwoMaxField = new JTextField();
				contentPane.add(SeriesTwoMaxField, "3, 7, fill, default");
				SeriesTwoMaxField.setColumns(10);
				
				lblSeriesTwoMin = new JLabel("Series Two Min");
				contentPane.add(lblSeriesTwoMin, "1, 9, right, default");
				
				SeriesTwoMinField = new JTextField();
				contentPane.add(SeriesTwoMinField, "3, 9, fill, default");
				SeriesTwoMinField.setColumns(10);
				
				lblSeriesTwoIntegration = new JLabel("Series Two Integration");
				contentPane.add(lblSeriesTwoIntegration, "1, 11, right, default");
				
				SeriesTwoIntegration = new JTextField();
				contentPane.add(SeriesTwoIntegration, "3, 11, fill, default");
				SeriesTwoIntegration.setColumns(10);
			
		}
		if(seriesNumber>2)
		{
			lblSeriesThreeMax = new JLabel("Series Three Max");
			contentPane.add(lblSeriesThreeMax, "1, 13, right, default");
			
			SeriesThreeMaxField = new JTextField();
			contentPane.add(SeriesThreeMaxField, "3, 13, fill, default");
			SeriesThreeMaxField.setColumns(10);
			
			lblSeriesThreeMin = new JLabel("Series Three Min");
			contentPane.add(lblSeriesThreeMin, "1, 15, right, default");
			
			SeriesThreeMinField = new JTextField();
			contentPane.add(SeriesThreeMinField, "3, 15, fill, default");
			SeriesThreeMinField.setColumns(10);
			
			
			lblSeriesThreeIntegration = new JLabel("Series Two Integration");
			contentPane.add(lblSeriesThreeIntegration, "1, 17, right, default");
			
			SeriesThreeIntegration = new JTextField();
			contentPane.add(SeriesThreeIntegration, "3, 17, fill, default");
			SeriesThreeIntegration.setColumns(10);
			
				
		}
		frame.pack();
	}
	public void updateData(final XYSeries series1, final XYSeries series2, final XYSeries series3) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {

				
				SeriesOneMaxField.setText(df.format(series1.getMaxY()));
				SeriesOneMinField.setText(df.format(series1.getMinY()));
				SeriesOneIntegration.setText(df.format(integration(series1)));
				if(seriesNumber>1)
				{
					SeriesTwoMaxField.setText(df.format(series2.getMaxY()));
					SeriesTwoMinField.setText(df.format(series2.getMinY()));
					SeriesTwoIntegration.setText(df.format(integration(series2)));
				}
				if(seriesNumber >2)
				{
					SeriesThreeMaxField.setText(df.format(series3.getMaxY()));
					SeriesThreeMinField.setText(df.format(series3.getMinY()));
					SeriesThreeIntegration.setText(df.format(integration(series3)));
				}
				
		    }
		  });
	}
	public double integration(XYSeries series)
	{
		double totalIntgration = 0;
		int seriesCount = series.getItemCount();

		for(int i = 0; i < seriesCount-1; i++)
		{
			double tempX = series.getX(i+1).doubleValue() - series.getX(i).doubleValue();
			double tempY = series.getY(i+1).doubleValue() + series.getY(i).doubleValue();
			totalIntgration = totalIntgration +  tempX *tempY;
		}
			
		totalIntgration = 0.5*totalIntgration;
	
		return totalIntgration;
	}
}
