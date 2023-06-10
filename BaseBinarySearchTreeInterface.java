/**
 * interface for the BaseBinarySearchTree, with all the specifications and methods that should be implemented in that class.
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * interface for the BaseBinarySearchTree, with all the specifications and methods that should be implemented in that class.
 * the type parameter of the interface extends Comparable interface.
 * @param <E>
 */
public interface BaseBinarySearchTreeInterface<E extends Comparable<E>>
{

    /**
     * method to get the root of the Binary Search Tree
     * @return the node with the root
     */
	public TreeNode<E> getRoot();
	
	/**
	 * method to change the root of the Binary Search Tree
	 * @param node the node to change the root to
	 */
	public void setRoot(TreeNode<E> node);
	
	/**
	 * method to check if the BST is empty
	 * @return true if BST is empty and false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * method to make the BST empty
	 */
	public void makeEmpty();
}
