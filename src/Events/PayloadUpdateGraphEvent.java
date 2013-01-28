package Events;

import java.util.EventObject;
import Data.Data;

public class PayloadUpdateGraphEvent  extends EventObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8526732845393991655L;
	public Data data;
	
	public  PayloadUpdateGraphEvent (Object source, Data data)
	{
		super(source);
		this.data = data;
		
	}
}



