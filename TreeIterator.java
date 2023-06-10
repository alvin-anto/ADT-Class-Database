/**
 * an iterator for a binary search tree.
 */
package ADT_BinarySearchTree;

//importing java.util library to use LinkedList
import java.util.*;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * an iterator for a binary search tree.
 * @param <E>
 */
public class TreeIterator<E extends Comparable<E>> implements java.util.Iterator<E> {
  
  //The binary search tree traversed by the iterator
  private BaseBinarySearchTree<E> BSTree;
 
  //linked list to store the ordered list of tree nodes traversed by the iterator
  private LinkedList<TreeNode<E>> linkedList;
  
  //constructor that takes in no parameters and sets the instance variables to null 
  public TreeIterator()
  {
	  this.BSTree = null;
	  this.linkedList = null;
  }

  //overridden constructor that takes in a binary search tree and sets the instance variable BSTree to that
  public TreeIterator(BaseBinarySearchTree<E> BST) 
  {
	  this.BSTree = BST;
      // empty queue indicates no traversal type currently
      // selected or end of current traversal has been reached
	  this.linkedList = new LinkedList<TreeNode<E>>();
  }

  /**
   * method to check if the iteration has more elements or not
   * @return true if the iteration has more elements and false if not
   */
  public boolean hasNext() 
  {
	  if (this.linkedList.isEmpty())
	  {
		  return false;
	  }
	  else
	  {
		  return true;
	  }
  }

  /**
   * method to return the next element in the iteration.
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  public E next() throws java.util.NoSuchElementException 
  {
      return this.linkedList.remove().getElement();
  }

  /**
   * method to return the last element returned by the iterator from the binary search tree
   * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
   */
  public void remove() throws UnsupportedOperationException
  {
      throw new UnsupportedOperationException();
  }

  /**
   * method to set the traversal type to be preorder.
   */
  public void setPreorder() 
  {
	  this.linkedList.clear();
      this.preorder(this.BSTree.treeRoot);
  }

  /**
   * method to set the traversal type to be inorder.
   */
  public void setInorder() 
  {
	  this.linkedList.clear();
      this.inorder(this.BSTree.treeRoot);
  }

  /**
   * method to set the traversal type to be postorder.
   */
  public void setPostorder() 
  {
	  this.linkedList.clear();
      this.postorder(this.BSTree.treeRoot);
  }

  /**
   * method to traverse the binary search tree in preorder. 
   * @param treeNode reference to a tree node
   */
  private void preorder(TreeNode<E> treeNode) 
  {
    if(treeNode != null){
    	this.linkedList.add(treeNode);
    	preorder(treeNode.getLeft());
    	preorder(treeNode.getRight());
    	
    }
  }

  /**
   * method to traverse the binary search tree in inorder. 
   * @param treeNode A reference to a tree node
   */
  private void inorder(TreeNode<E> treeNode) 
  {
	  if(treeNode != null){
	    	inorder(treeNode.getLeft());
	    	this.linkedList.add(treeNode);
	    	inorder(treeNode.getRight());
	    	
	    }
  }

  /**
   * method to traverse the binary search tree in postorder. 
   * @param treeNode A reference to a tree node
   */
  private void postorder(TreeNode<E> treeNode) 
  {
	  if(treeNode != null){
		    postorder(treeNode.getLeft());
	    	postorder(treeNode.getRight());
	    	this.linkedList.add(treeNode);
	    	
	    }
  } 
}
