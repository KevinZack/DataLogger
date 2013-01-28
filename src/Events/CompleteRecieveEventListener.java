package Events;

import Parsers.FactorData;



public class CompleteRecieveEventListener  implements ICompleteRevieveEventListener
{
	public FactorData factorData;
	
	public CompleteRecieveEventListener(FactorData factorData) 
	{
		this.factorData = factorData;
	}

	@Override
	public void CompleteRevieveEventHandler(CompleteRecieveEvent event) 
	{
		factorData.updateString(event.inputString);
	}
}

