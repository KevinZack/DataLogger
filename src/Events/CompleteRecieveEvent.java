package Events;
import java.util.EventObject;

public class CompleteRecieveEvent extends EventObject 
{
	private static final long serialVersionUID = 6119219957704894376L;
	public String inputString;

	public CompleteRecieveEvent (Object source, String __inputString)
	{
		super(source);
		inputString = __inputString;
	}
}
