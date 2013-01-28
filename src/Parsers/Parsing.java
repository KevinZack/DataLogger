package Parsers;

import javax.swing.SwingUtilities;
import Data.Data;
import Gui.Errors;
import Gui.Window;


public class Parsing extends Thread
{
	public DataWriter dataWriter;
	public String finalString = "";
	public String addString = "";
	public String middleString = "";
	public String tempString = "";
	public String masterString = "";
	public String[] tempStringArray;
	public Data data;
	public Window window;
	public Errors errors;
	public FactorData factorData;
	
	public double timeFactor = 1;
	public double sensorOneFactor = 1;
	public double sensorTwoFactor = 1;
	public double sensorThreeFactor = 1;
	public double sensorFourFactor = 1;
	public double sensorFiveFactor = 1;
	public double sensorSixFactor = 1;
	
	public long totalEntries = 0;
	public long totalSensorOne = 0;
	public long totalSensorTwo = 0;
	public long totalSensorThree = 0;
	public long totalSensorFour = 0;
	public long totalSensorFive = 0;
	public long totalSensorSix = 0;
	
	public String firstString;
	public boolean stringSet = false;
	public boolean sizeSet = false;
	public int size = 0;
	public boolean saveData = true;
	public int lengthOfSep = 0;
	public boolean showErrors = false;
	public int errorNumber = 0;
	public long totalErrorEntries = 0;
	
	
	public Parsing()
	{
		dataWriter = new DataWriter("Raw");
		factorData = new FactorData(this);
	}

	
	public void changeFactors(final double _timeFactor, final double _SensorOneFactor, final double _SensorTwoFactor
			,final double _SensorThreeFactor,final double _SensorFourFactor
			,final double _SensorFiveFactor, final double _SensorSixFactor) 
	{
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {
		    	timeFactor = _timeFactor;
		    	sensorOneFactor = _SensorOneFactor;
		    	sensorTwoFactor = _SensorTwoFactor;
		    	sensorThreeFactor = _SensorThreeFactor;
		    	sensorFourFactor = _SensorFourFactor;
		    	sensorFiveFactor = _SensorFiveFactor;
		    	sensorSixFactor = _SensorSixFactor;
		    }
		  });
	}
	
	public void activateWindow()
	{
		window = new Window(this);
	}
	
	public void finalString(final String streamInString) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {
		    	String tempString = streamInString.replaceAll("[\n\r]", "");
		    	
		    	if(tempString.startsWith("@"))
		    	{
		    		if(!sizeSet)
		    		{
		    			size = getSize(streamInString);
		    			activateWindow();
		    		}
		    		
		    		try
		    		{
		    			totalEntries++;
		    			totalErrorEntries++;
		    		
		    		dataWriter.run(tempString);
		    		data = new Data();		    		
		    		String[] seperatedData = tempString.split(",");
		    		
		    		if(seperatedData.length == lengthOfSep)
		    		{
			    		data.time = Double.parseDouble(seperatedData[1])*timeFactor;
			    		
			    		data.sensorOne = Double.parseDouble(seperatedData[2])*sensorOneFactor;
			    		totalSensorOne += data.sensorOne;
			    		
			    		if(size > 1)
			    		{
			    			data.sensorTwo = Double.parseDouble(seperatedData[3])*sensorTwoFactor;
			    			totalSensorTwo += data.sensorTwo;
			    		}
			    		if(size > 2)
			    		{
				    		data.sensorThree = Double.parseDouble(seperatedData[4])*sensorThreeFactor;
				    		totalSensorThree += data.sensorThree;	
			    		}
			    		if(size > 3)
			    		{
			    			data.sensorFour = Double.parseDouble(seperatedData[5])*sensorFourFactor;
			    			totalSensorFour += data.sensorFour;
			    		}
			    		if(size > 4)
			    		{
			    			data.sensorFive = Double.parseDouble(seperatedData[6])*sensorFiveFactor;
			    			totalSensorFive += data.sensorFive;
			    			
			    		}
			    		if(size > 5)
			    		{
			    			data.sensorSix = Double.parseDouble(seperatedData[7])*sensorSixFactor;
			    			totalSensorSix += data.sensorSix;
			    		}
		    		}
		    		else
		    		{
		    			errorNumber++;
		    			saveData = false;
		    		}
		    		}
			    	catch(NumberFormatException e)
			    	{
			    		saveData = false;
			    		errorNumber++;
			    		e.printStackTrace();
			    	}
			    	catch(ArrayIndexOutOfBoundsException e1)
			    	{
			    		errorNumber++;
			    		saveData = false;
			    		e1.printStackTrace();
			    	}
			    	if(saveData)//
			    	{
			    		window.updateData(data);
			    	}
			    	saveData = true;
			    	if(showErrors)
			    	{
			    		errors.updateErrors(errorNumber, totalErrorEntries, data.time);
			    	}
			    }
		    	
		    }
		  });
		  
		}
	public int getSize(String streamInString)
	{
		int size = 0;
		if(!stringSet)
    	{
    		for(int i = 0; i < streamInString.length(); i++)
    		{
    			if(streamInString.charAt(i) == ',')
    			{
    				size++;
    			}
    		}
    		size = size-2;
    		stringSet=true;
    		
    		String tempString = streamInString.replaceAll("[\n\r]", "");
    		String[] seperatedData = tempString.split(",");
    		lengthOfSep = seperatedData.length;
    		
    		sizeSet = true;
    		
    	}
		return size;
	}
	public void setErrors()
	{
		errors = new Errors(this);
		showErrors = true;
	}
	
}
