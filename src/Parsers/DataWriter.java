package Parsers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataWriter extends Thread
{
	private File directory;
	private String filePath;
	
	public BufferedWriter dataFile;
	public DataWriter(String type)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		if(type.equals("Raw"))
		{
			createDirectoryIfNeeded("Log");
			createDirectoryIfNeeded("Log/Raw");
			filePath = "Log/Raw/Raw_"+dateFormat.format(date)+".csv";
		}
		else if(type.equals("Formated"))
		{
			createDirectoryIfNeeded("Log");
			createDirectoryIfNeeded("Log/Formated");
			filePath = "Log/Formated/Formated_"+dateFormat.format(date)+".csv";
		}
		FileWriter fstream = null;

		try 
		{
			fstream = new FileWriter(filePath);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		dataFile = new BufferedWriter(fstream);
		this.start();
	}
	
	public void run(final String returnString)
	{
		try 
		{
			dataFile.write(returnString);
			dataFile.newLine();
			dataFile.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	 private void createDirectoryIfNeeded(String directoryLocation)
	  {
		  directory = new File(directoryLocation);
		  
		  if (!directory.exists())
		  {
			  directory.mkdir();
		  }
	  }

}
