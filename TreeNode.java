/**
 * The generic TreeNode<E> class is created that can be instantiated to create a node containing an element of any reference type.
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * The generic TreeNode<E> class is created that can be instantiated to create a node containing an element of any reference type.
 * @param <E>
 */
public class TreeNode<E> 
{

	//variable to store the element in the tree node
	private E element;
	
	//TreeNode<E> reference variable to point to the left node of the node
	private TreeNode<E> left;
	
	//TreeNode<E> reference variable to point to the right node of the node
	private TreeNode<E> right;
	
	//constructor that takes in no parameters and sets all the instance variables to null
	public TreeNode()
	{
		this.element = null;
		this.left = null;
		this.right = null;
	}
	
	//overloaded constructor that takes in the element as the parameter and store that to the element instance variable
	public TreeNode(E element)
	{
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	//overloaded constructor that takes in values as the parameters and store those to the instance variables
	public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) 
	{
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * method to return the element
	 * @return element
	 */
	public E getElement()
	{
		return this.element;
	}
	
	/**
	 * method to return a reference to the left node
	 * @return left node
	 */
	public TreeNode<E> getLeft()
	{
		return left;
	}
	
	/**
	 * method to return a reference to the right node
	 * @return right node
	 */
	public TreeNode<E> getRight()
	{
		return right;
	}
	
	/**
	 * method to change the element in a tree node
	 * @param element
	 */
	public void setElement(E element)
	{
		this.element = element;
	}
	
	/**
	 * method to change the left node pointer
	 * @param left
	 */
	public void setLeft(TreeNode<E> left)
	{
		this.left = left;
	}
	
	/**
	 * method to change the right node pointer
	 * @param right
	 */
	public void setRight(TreeNode<E> right)
	{
		this.right = right;
	}
	
	/**
	 * overridden equals method to check if both elements are equals
	 * @param temp
	 * @return true if the elements are equal and false otherwise
	 */
	public boolean equals(TreeNode<E> temp) 
	{
		if (this.getElement().equals(temp))
		{
			return true;
		}
		return false;
	}

}
