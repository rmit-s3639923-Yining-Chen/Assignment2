
public class NotBeFriendException extends  Exception
{
	public NotBeFriendException() 
	{
		super("Two persons are teenager, age gap over 3 years, cannot add relationship!");
	}
}
