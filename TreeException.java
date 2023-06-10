/**
 * The exception class handles the error when there is a run time error.
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * The exception class handles the error when there is a run time error.
 * creates a TreeException class, that prints an exception message, that extends RuntimeException
 */
public class TreeException extends RuntimeException
{

	//constructor that takes in the error message as the parameter and prints it
	public TreeException(String msg) 
	{
		super(msg);
	}

}
