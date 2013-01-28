package Events;

import java.util.EventObject;

public class CompleteConnectEvent extends EventObject 
{
	private static final long serialVersionUID = -1298252356347935141L;
	public String com;

	public CompleteConnectEvent (Object source, String com)
	{
		super(source);
		this.com = com;
	}
}
