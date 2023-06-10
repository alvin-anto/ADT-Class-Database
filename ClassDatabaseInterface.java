/**
 * the ClassDatabaseInterface consists of all the specifications and operations that the ClassDatabase class need to implement
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * the ClassDatabaseInterface consists of all the specifications and operations that the ClassDatabase class need to implement
 */
public interface ClassDatabaseInterface 
{
	/**
	 * method to insert a new class section
	 * @param classSec
	 */
	public void insertClass(Class_Section classSec);
	
	/**
	 * method to delete a class section that is passed as the argument
	 * @param classSec
	 */
	public void deleteClass(Class_Section classSec);
	
	/**
	 * overloaded method to delete a class section with the class number that is passed as the argument
	 * @param i
	 */
	public void deleteClass(int i);
	
	/**
	 * method to search for a class section passed as the argument and returns the reference to the node with the class section
	 * @param classSec
	 * @return the reference to the node with the class section passed as the argument
	 */
	public TreeNode<Class_Section> searchClass(Class_Section classSec);
	
	/**
	 * overloaded method to search for the class section with the class number passed as the argument and returns the reference to the node with that class section
	 * @param i
	 * @return the reference to the node with the class section with the class number passed as the argument
	 */
	public Class_Section searchClass(int i);
	
	/**
	 * method to check if the class database is empty
	 * @return true if the database is empty and false if it is not
	 */
	public boolean isDatabaseEmpty();
	
	/**
	 * method to make the class database empty
	 */
	public void makeDatabaseEmpty();
	
	/**
	 * method to traverse this class database in an inorder traversal, store the class sections in a linked list and 
	 * return a reference of the list
	 * @return the reference of the list that has the ordered nodes after traversal
	 */
	public TreeIterator<Class_Section> sort();
	
	/**
	 * method to return the number of class sections in the database
	 * @return the total number of class sections in the database
	 */
	public int totalNumberOfClassSections();
	
	/**
	 * method to convert the binary search tree into an array where all the class sections are sorted
	 * @return the array with all the class sections sorted, that were in the binary search tree
	 */
	public Class_Section[] convertToArray();
}
