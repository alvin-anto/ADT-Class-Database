/**
 * Class_Section class which consists of a class number, a course subject, a catalog number, a class title and a level. 
 * Each class section has a unique class number.
 */
package ADT_BinarySearchTree;

/**
 * @author alvinanto
 * 04/29/2022
 */

/**
 * The class Class_Section consists of a class number, a course subject, a catalog number, a class title and a level where the class number is unique to each class section
 */
public class Class_Section implements Comparable<Class_Section>{

	//int variable for storing the class number
	private int classNo;
	
	//String variable to store the course subject
	private String courseSub;
	
	//int variable to store the catalog number
	private int catalogNo;
	
	//String variable to store the class title
	private String classTitle;
	
	//String variable to store the course level
	private String level;
	
	//constructor with no parameter
	public Class_Section() 
	{

	}

	//overloaded constructor that stores the class number passed as the parameter to the classNo instance variable
	public Class_Section(int classNo)
	{
		this.classNo = classNo;
	}
	
	//overloaded constructor that stores all the values passed as parameters to the instance variables.
	public Class_Section(int classNo, String courseSub, int catalogNo, String classTitle, String level) 
	{
		this.classNo = classNo;
		this.courseSub = courseSub;
		this.catalogNo = catalogNo;
		this.classTitle = classTitle;
		this.level = level;
	}
	
	/**
	 * method to return the class number
	 * @return class number
	 */
	public int getClassNo()
	{
		return classNo;
	}
	
	/**
	 * method to return the course subject
	 * @return course subject
	 */
	public String getCourseSub()
	{
		return courseSub;
	}
	
	/**
	 * method to return the catalog number
	 * @return catalog number
	 */
	public int getCatalogNo()
	{
		return catalogNo;
	}
	
	/**
	 * method to return the clas title
	 * @return class title
	 */
	public String getClassTitle()
	{
		return classTitle;
	}

	/**
	 * method to return the class level
	 * @return class level
	 */
	public String getLevel()
	{
		return level;
	}
	
	/**
	 * method to change the class number
	 * @param num the class number
	 */
	public void setClassNo(int num)
	{
		this.classNo = num;
	}
	
	/**
	 * method to change the course subject
	 * @param sub the course subject
	 */
	public void setCourseSub(String sub)
	{
		this.courseSub = sub;
	}
	
	/**
	 * method to change the catalog number
	 * @param num the catalog number
	 */
	public void setCatalogNo(int num)
	{
		this.catalogNo = num;
	}
	
	/**
	 * method to change the class title
	 * @param title the class title
	 */
	public void setClassTitle(String title)
	{
		this.classTitle = title;
	}
	
	/**
	 * method to change the level of the class
	 * @param lev the class level
	 */
	public void setLevel(String lev)
	{
		this.level = lev;
	}
	
	/**
	 * method to check if the class section is empty
	 * @return true if the class section is empty and false if it is not
	 */
	public boolean isEmpty()
	{
		return (this == null);
	}
	
	/**
	 * overridden toString() method, to print the class number, class subject, catalog number, class title and class level
	 */
	public String toString()
	{
		return Integer.toString(getClassNo()) + "\t" + getCourseSub() + "\t" + Integer.toString(getCatalogNo()) + "\t" + getClassTitle() + "\t" + getLevel() +"\n";
	}
	

	/**
	 * Overridden compareTo method to compare the class numbers becuase the class number is unique to each class section
	 */
	@Override
	public int compareTo(Class_Section newSection) 
	{
		if (this.getClassNo() > newSection.getClassNo())
		{
			return 1;
		}
		else if (this.getClassNo() < newSection.getClassNo())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
}
