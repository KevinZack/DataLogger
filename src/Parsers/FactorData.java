package Parsers;

import javax.swing.SwingUtilities;

import Events.CompleteRecieveEventListener;
import Main.DataManager;



public class FactorData extends Thread
{
	public Parsing parsing;

	
	public String finalString = "";
	public String middleString = "";
	
	public  FactorData(Parsing parsing)
	{
		this.parsing = parsing;
		DataManager.addCompleteRevieveEvent(new CompleteRecieveEventListener(this));
		this.start();
	}
	
	public void run()
	{
		while(true)
		{
			int secondAmpersand = middleString.indexOf("@",1);
			int firstPound = middleString.indexOf("#");
			
			if(firstPound != -1 && secondAmpersand != -1)
			{
				finalString = middleString.substring(0,firstPound+1);
				middleString =  middleString.substring(secondAmpersand);
			}
			if(finalString != "")
			{
				parsing.finalString(finalString);
			}
			
			finalString = "";
			
  			try {Thread.sleep(10);} catch (InterruptedException e){}
			
		}
	}
	
	public void updateString(final String streamInString) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() 
		    {
		    	middleString += streamInString;
		    }
		  });
		}
}
