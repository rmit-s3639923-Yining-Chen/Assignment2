/**
* This is NoAvaibleException class 
*
* @version 1.00 14 May 2018
* @author Yining Chen
*/
public class NoAvaibleException extends Exception {
	public NoAvaibleException() 
	{
		super("One of them is already a partner with other person!");
	}
}
