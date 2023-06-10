/**
 * the helper method which tests all the operations and methods of the class data base created using binary search tree as the data structure
 */
package ADT_BinarySearchTree;

//importing java.io library for taking input from the text file
import java.io.*;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * the helper method which tests all the operations and methods of the class data base created using binary search tree as the data structure
 */
public class Helper 
{
	//a static class section reference variable
	private static Class_Section classSec;
	
	//a static class database reference variable
	private static ClassDatabase list;
	
	/**
	 * the method calls insert and display method and tests all the operations and methods of the class data base
	 * @throws IOException
	 */
	public static void start() throws IOException
	{
		list = new ClassDatabase();
		create(list);
		System.out.println("Database created");
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections());
		list.deleteClass(3856);
		System.out.println("\nClass deleted from the Database");
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections());
		Class_Section cls = new Class_Section(6325,"APHI",110,"Introduction to Philisophical Problems","Undergraduate");
		list.insertClass(cls);
		System.out.println("\nNew Class added to the Database");
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections());
		list.insertClass(new Class_Section(3121));
		System.out.println("\nNew Class added to the Database");
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections());
		list.deleteClass(7300);
		System.out.println("\nClass deleted the Database");
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections());
		list.deleteClass(3121);
		System.out.println("\nClass deleted the Database");
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections() +"\n");
		display(list);
		System.out.println("Class Section Found in the Database:\n" + list.searchClass(6325));
		System.out.println("Class Section Found in the Database:\n" + list.searchClass(3862));
		System.out.println("Is the Database empty?\t" + list.isDatabaseEmpty() + "\n");
		list.makeDatabaseEmpty();
		System.out.println("\nIs the Database empty?\t" + list.isDatabaseEmpty());
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections() + "\n");
		display(list);
		System.out.println("\nRefilling the Database");
		create(list);
		System.out.println("\nDisplaying the contents of the array formed with the Class_Section objects in the ClassDatabase:-\n");
		list.printArrayDatabaseOfClassSections();
		System.out.println("\nTotal number of class Sections currently in the database: " + list.totalNumberOfClassSections() + "\n");
		display(list);
		System.out.println("Total number of class Sections currently in the database: " + list.totalNumberOfClassSections() + "\n");
	}
	
	/**
	 * method to fill all the class sections taken from the text file to the binary search tree and hence creating a class database
	 * @param l
	 * @throws IOException
	 */
	public static void create(ClassDatabase l) throws IOException
	{
		list = new ClassDatabase();
		
		//creating a new FileReader object with "classSections.txt".
		FileReader file1 = new FileReader("classSections.txt");
		
		//creating BufferedReader object with file1.
		BufferedReader file2 = new BufferedReader(file1);
		
		//reads the first line from the text file.
		String line = file2.readLine();
		String[] stringTokens = line.split(",");
		classSec = new Class_Section(Integer.parseInt(stringTokens[0]), stringTokens[1], Integer.parseInt(stringTokens[2]), stringTokens[3], stringTokens[4]);
		list.insertClass(classSec);
		
		//reads the next line
		line = file2.readLine();
		
		//the loop is ran till there is no other class sections in the text file
		while (line != null)
		{
			stringTokens = line.split(",");
			classSec = new Class_Section(Integer.parseInt(stringTokens[0]), stringTokens[1], Integer.parseInt(stringTokens[2]), stringTokens[3], stringTokens[4]);
			list.insertClass(classSec);
			line = file2.readLine();
		}
		
		//close the files used for taking input from the text file.
		file2.close();
		file1.close();		
		
		
	}
	
	/**
	 * method to display all the class sections in the binary search tree of the class database in the ascending order
	 * @param l
	 */
	public static void  display(ClassDatabase l)
	{
		TreeIterator<Class_Section> iteration = list.sort();
		iteration.setInorder();
		System.out.println("Class Database:");
		//the loop is run till the iteration has any more class sections
		while (iteration.hasNext())
		{
			Class_Section temp = iteration.next();
			if (temp == null)
			{
				continue;
			}
			System.out.println(temp);
		}
	
	}

}
