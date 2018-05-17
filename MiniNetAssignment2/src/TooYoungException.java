/**
* This is TooYoungException class 
*
* @version 1.00 14 May 2018
* @author Yining Chen
*/
public class TooYoungException extends Exception
{
    public TooYoungException()
    {
    	super("One person is teenager, cannot add relationship!");
    }
}
