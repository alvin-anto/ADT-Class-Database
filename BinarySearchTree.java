/**
 * BinarySearchTree class extends BaseBinarySearchTree class and consists of all the operations on the binary search tree except on the root
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * BinarySearchTree class extends BaseBinarySearchTree class and consists of all the operations on the binary search tree except on the root
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> extends BaseBinarySearchTree<E>
{

	//constructor that takes in no parameter and make the tree root null which is from the super class
	public BinarySearchTree() 
	{
		super.treeRoot = null;
	}
	
	//overloaded constructor that takes in element as the parameter and pass that as argument for the super class constructor
	public BinarySearchTree(E element)
	{
		super(element);
	}
	
	/**
	 * method to recursively search for the element passed as the argument from the node that is also an argument
	 * @param node
	 * @param element
	 * @return TreeNode<E> that references the node with the element being searched for
	 * @throws TreeException
	 */
	public TreeNode<E> searchRecursively(TreeNode<E> node, E element) throws TreeException
	{
		//if the binary search tree is empty
		if (this.isEmpty())
		{
			throw new TreeException("The tree is empty. There is no element");
		}
		else
		{
			//if the element is null
			if (node.getElement() == null)
			{
				throw new TreeException("There is no such element in the treeTT");
			}
			//if the element is equal to the element being searched for 
			else if (node.getElement().compareTo(element) == 0)
			{
				return node;
			}
			//if the element is greater than the element being searched for
			else if (node.getElement().compareTo(element) > 0)
			{
				//if the node has no left nodes
				if (node.getLeft() == null)
				{
					throw new TreeException("There is no such element in the tree.");
				}
				//if the node has a left node
				else
				{
					return searchRecursively(node.getLeft(), element);
				}
			}
			//if the element is smaller than the element being searched for
			else
			{
				//if the node does not have a right node
				if (node.getRight() == null)
				{
					throw new TreeException("There is no such element in the tree.");
				}
				//if the node has a right node
				else
				{
					return searchRecursively(node.getRight(), element);
				}
			}
		}
	}
	
	/**
	 * method calls searchRecursively method every time it is called.
	 * @param element
	 * @return tree node that references the element being searched for
	 */
	public TreeNode<E> search(E element)
	{
		return searchRecursively(this.treeRoot, element);
	}
	
	/**
	 * method to recursively search for the perfect node to place the element and then insert it there so that it conserves the properties of Binary search tree	
	 * @param node
	 * @param element
	 * @throws TreeException
	 */
	public  void insertRecursively(TreeNode<E> node, E element) throws TreeException
	{
		//if the elements are equal
		if (node.getElement().compareTo(element) == 0)
		{
			throw new TreeException("Duplicate Element Found.");
		}
		else
		{
			//if the element is greater than the element to be inserted
			if (node.getElement().compareTo(element) > 0)
			{
				//if the left node of the node is null
				if (node.getLeft() == null)
				{
					node.setLeft(new TreeNode<E>(element));
				}
				//if the left node of the node has an element
				else
				{
					insertRecursively(node.getLeft(), element);
				}
			}
			//if the element is smaller than the element to be inserted
			else
			{
				//if the node does not have a right node
				if (node.getRight() == null)
				{
					node.setRight(new TreeNode<E>(element));
				}
				//if the node has a right node
				else
				{
					insertRecursively(node.getRight(), element);
				}
			}
		}
	}
	
	/**
	 * method that calls insertRecursively method every time it is classed and inserts the element in the binary search tree
	 * @param element
	 */
	public void insert(E element)
	{
		if (this.treeRoot == null)
		{
			this.treeRoot = new TreeNode<E>(element);
		}
		else
		{
			insertRecursively(this.treeRoot, element);
		}
	}
	/**
	 * method to find the maximum in the left subtree
	 * @param baseNode
	 * @return the maximum in the left subtree
	 */
	public TreeNode<E> findLeftMax(TreeNode<E> baseNode)
	{
		TreeNode<E> temp = baseNode.getLeft();
		while (!(temp.getRight() == null))
		{
			temp = temp.getRight();
		}
		return temp;
	}
	
	/**
	 * method to find the parent node of the maximum in the left subtree
	 * @param baseNode
	 * @return
	 */
	public TreeNode<E> findParentOfLeftMax(TreeNode<E> baseNode)
	{
		int count = 0;
		TreeNode<E> tempPrev = baseNode;
		TreeNode<E> temp = baseNode.getLeft();
		while (!(temp.getRight() == null))
		{
			count++;
			tempPrev = temp;
			temp = temp.getRight();
		}
		if  (count == 0)
		{
			return new TreeNode<E>();
		}
		return tempPrev;
	}
	
	/**
	 * method to delete a node with an element euqal to the argument
	 * @param element
	 */
	public void delete(E element)
	{
		TreeNode<E> curr;
		curr = this.search(element);
		
		//if there is no left node or a right node
		if ((curr.getLeft() == null) && (curr.getRight() == null))
		{
			curr.setElement(null);
		}
		else
		{
			//if there is both left and right node child
			if ((curr.getLeft() != null) && (curr.getRight()!= null))
			{
				
				TreeNode<E> tempNodePrev = this.findParentOfLeftMax(curr);
				TreeNode<E> tempNode = this.findLeftMax(curr);
				tempNodePrev.setRight(tempNode.getLeft());
				curr.setElement(tempNode.getElement());
				if (tempNodePrev.getElement() == null)
				{
					tempNode.setElement(null);
				}
					
			}
			//if it has only one child, either left or right
			else
			{
				//if the left node of the node is null
				if (curr.getLeft() == null)
				{
					curr.setElement(curr.getRight().getElement());
					curr.setLeft(curr.getRight().getLeft());
					curr.setRight(curr.getRight().getRight());
				}
				//if the right node of the node is null
				else
				{
					curr.setElement(curr.getLeft().getElement());
					curr.setLeft(curr.getLeft().getLeft());
					curr.setRight(curr.getLeft().getRight());
				} 
			}
		}
		
	}
	
	/**
	 * method to construct a new TreeIterator<E> and return that
	 * @return a new TreeIterator<E>
	 */
	public TreeIterator<E> constructIterator()
	{
		TreeIterator<E> temp = new TreeIterator<E>(this);
		return temp;
	}
	
	/**
	 * method to get a reference to the node with the element being passed as the argument
	 * @param element
	 * @return the reference to the node that contains the element
	 */
	public TreeNode<E> getReference(E element)
	{
		return this.search(element);
	}

}
