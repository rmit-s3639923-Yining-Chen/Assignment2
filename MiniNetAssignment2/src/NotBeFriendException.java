/**
* This is NotBeFriendException class.
*
* @version 1.00 13 March 2018
* @author Tianyu Tan(Terry)
*/
public class NotBeFriendException extends  Exception
{
	public NotBeFriendException() 
	{
		super("Two persons are teenager, age gap over 3 years, cannot add relationship!");
	}
}
