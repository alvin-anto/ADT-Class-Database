/**
 * the ClassDatabase class implements ClassDatabaseInterface and implements all the operations and methods in there
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * the ClassDatabase class implements ClassDatabaseInterface and implements all the operations and methods in there
 */
public class ClassDatabase implements ClassDatabaseInterface
{
	//a BinarySearchTree reference variable that is storing a new BST for this database
	private BinarySearchTree<Class_Section> BST;
	
	//an int variable to keep track of the number of class sections in the database
	private int totalNumber = 0;
	
	//constructor that takes in no parameters and creates a BST with no class sections
	public ClassDatabase() 
	{
		BST = new BinarySearchTree<Class_Section>();
	}
	
	//overloaded constructor that takes in a BST as the argument and stores that to the instance variable
	public ClassDatabase(BinarySearchTree<Class_Section> classSec) 
	{
		BST = classSec;
	}
	
	/**
	 * method to insert a new class section
	 * @param classSec
	 */
	public void insertClass(Class_Section classSec)
	{
		BST.insert(classSec);
		this.totalNumber = this.totalNumber + 1;
	}
	
	/**
	 * method to delete a class section that is passed as the argument
	 * @param classSec
	 */
	public void deleteClass(Class_Section classSec)
	{
		BST.delete(classSec);
		this.totalNumber = this.totalNumber - 1;
	}
	
	/**
	 * overloaded method to delete a class section with the class number that is passed as the argument
	 * @param i
	 */
	public void deleteClass(int i)
	{
		//Class_Section temp = new Class_Section(i);
		this.deleteClass(this.searchClass(i));
	}
	
	/**
	 * method to search for a class section passed as the argument and returns the reference to the node with the class section
	 * @param classSec
	 * @return the reference to the node with the class section passed as the argument
	 */
	public TreeNode<Class_Section> searchClass(Class_Section classSec)
	{
		return BST.search(classSec);
	}
	
	/**
	 * overloaded method to search for the class section with the class number passed as the argument and returns the reference to the node with that class section
	 * @param i
	 * @return the reference to the node with the class section with the class number passed as the argument
	 */
	public Class_Section searchClass(int i)
	{
		Class_Section temp = new Class_Section(i);
		return this.searchClass(temp).getElement();
	}
	
	/**
	 * method to check if the class database is empty
	 * @return true if the database is empty and false if it is not
	 */
	public boolean isDatabaseEmpty()
	{
		boolean ans = BST.isEmpty();
		return ans;
	}
	
	/**
	 * method to make the class database empty
	 */
	public void makeDatabaseEmpty()
	{
		BST.makeEmpty();
		this.totalNumber = 0;
		System.out.println("Database cleared.");
	}
	
	/**
	 * method to traverse this class database in an inorder traversal, store the class sections in a linked list and 
	 * return a reference of the list
	 * @return the reference of the list that has the ordered nodes after traversal
	 */
	public TreeIterator<Class_Section> sort()
	{
		return BST.constructIterator();
	}
	
	/**
	 * method to return the number of class sections in the database
	 * @return the total number of class sections in the database
	 */
	public int totalNumberOfClassSections()
	{
		return this.totalNumber;
	}
	
	/**
	 * method to convert the binary search tree into an array where all the class sections are sorted
	 * @return the array with all the class sections sorted, that were in the binary search tree
	 */
	public Class_Section[] convertToArray()
	{
		Class_Section[] classArray = new Class_Section[this.totalNumber];
		TreeIterator<Class_Section> it = this.sort();
		it.setInorder();
		int indexCount = 0;
		while (it.hasNext())
		{
			Class_Section temp = it.next();
			if (temp == null)
			{
				continue;
			}
			classArray[indexCount] = temp;
			indexCount++;
		}
		return classArray;
	}
	
	/**
	 * method to call the convertToArray() method and then prints the elements of the array returned by that method
	 */
	public void printArrayDatabaseOfClassSections()
	{
		Class_Section[] classArray = this.convertToArray();
		for (int i = 0; i < classArray.length; i++)
		{
			System.out.println(classArray[i]);
		}
	}

}
