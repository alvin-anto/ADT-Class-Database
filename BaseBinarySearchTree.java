/**
 * BaseBinarySearchClass implements BaseBinarySeacrhTreeInterface and consists of all the operations on the root of the binary search tree
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * BaseBinarySearchClass implements BaseBinarySeacrhTreeInterface and consists of all the operations on the root of the binary search tree
 * the type parameter of the class extends Comparable interface.
 * @param <E>
 */
public class BaseBinarySearchTree<E extends Comparable<E>> implements BaseBinarySearchTreeInterface<E>
{

	//TreeNode<E> reference variable treeRoot for storing the root node of the binary search tree
	protected TreeNode<E> treeRoot;
	
	//constructor that takes in no parameters and makes the tree root null
	public BaseBinarySearchTree() 
	{
		this.treeRoot = null;
	}
	
	//overloaded constructor that takes in the element and store that to the tree root
	public BaseBinarySearchTree(E root)
	{
		this.treeRoot.setElement(root);
		this.treeRoot.setLeft(null);
		this.treeRoot.setRight(null);
	}
	
	//overloaded constructor that takes in the tree node and make it the tree node
	public BaseBinarySearchTree(TreeNode<E> treeRoot)
	{
		this.treeRoot = treeRoot;
	}
    
	/**
     * method to get the root of the Binary Search Tree
     * @return the node with the root
     */
	public TreeNode<E> getRoot() 
	{
		if (this.treeRoot == null)
		{
			throw new TreeException("The root is empty.");
		}
		return this.treeRoot;
	}
	
	/**
	 * method to change the root of the Binary Search Tree
	 * @param node the node to change the root to
	 */
	public void setRoot(TreeNode<E> node)  throws UnsupportedOperationException
	{
		this.treeRoot = node;	
	}

	/**
	 * method to check if the BST is empty
	 * @return true if BST is empty and false otherwise
	 */
	public boolean isEmpty() 
	{
		return (this.treeRoot == null);
	}

	/**
	 * method to make the BST empty
	 */
	public void makeEmpty() 
	{
		this.treeRoot = null;
	}

}
