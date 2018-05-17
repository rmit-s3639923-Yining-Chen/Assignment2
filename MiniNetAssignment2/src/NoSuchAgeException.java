/**
* This is NoSuchAgeException class 
*
* @version 1.00 14 May 2018
* @author Yining Chen
*/
public class NoSuchAgeException extends Exception  {
	public NoSuchAgeException() 
	{
		super("Age is over 150!");
	}
}
